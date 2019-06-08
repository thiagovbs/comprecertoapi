package br.com.comprecerto.api.services;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.exceptions.FileException;

@Service
public class ImageService {

    @Autowired
    private S3Service s3Service;


    public BufferedImage getJpgImageFromFile(MultipartFile uploadedFile) {

        String ext = FilenameUtils.getExtension(uploadedFile.getOriginalFilename());
        if (!"png".equals(ext) && !"jpg".equals(ext)) {
            throw new FileException("Somente imagens PNG e JPG são permitidas");
        }

        try {
            BufferedImage img = ImageIO.read(uploadedFile.getInputStream());

            if ("png".equals(ext)) {
                img = pngToJpg(img);
            }
            return img;
        } catch (IOException e) {
            throw new FileException("Erro ao ler arquivo");
        }
    }

    public BufferedImage pngToJpg(BufferedImage img) {

        BufferedImage jpgImage = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
        jpgImage.createGraphics().drawImage(img, 0, 0, Color.WHITE, null);
        return jpgImage;
    }

    public InputStream getInputStream(BufferedImage img, String extension) {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(img, extension, os);
            return new ByteArrayInputStream(os.toByteArray());
        } catch (IOException e) {
            throw new FileException("Erro ao ler arquivo");
        }
    }

    public String salvaImagemFromBase64(String imagem, String filename) {    	
        try {
            InputStream is = new ByteArrayInputStream(new Base64().decode(imagem.replaceFirst("^.*,", "")));

            BufferedImage image;
            image = ImageIO.read(is);
            is.close();

            String nomeArquivoImagem = filename + ".png";
            FileUtils.touch(new File("src/main/resources/" + nomeArquivoImagem));
            File arquivoFoto = new File("src/main/resources/" + nomeArquivoImagem);


            ImageIO.write(image, "png", arquivoFoto);

            URI uri = s3Service.uploadFile(new FileInputStream(arquivoFoto), nomeArquivoImagem, "png");

            deletaArquivoTemp(arquivoFoto);

            return uri.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public boolean deletaArquivoS3(String URL) throws IOException {
    	return s3Service.deleteFile(URL);
    }

    private void deletaArquivoTemp(File arquivo) throws IOException {
        Files.delete(Paths.get(arquivo.getPath()));
    }
}

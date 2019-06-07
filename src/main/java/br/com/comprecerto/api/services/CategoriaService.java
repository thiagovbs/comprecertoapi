package br.com.comprecerto.api.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.repositories.CategoriaRepository;
import br.com.comprecerto.api.repositories.MercadoPushRepository;
import br.com.comprecerto.api.repositories.ProdutoRepository;
import br.com.comprecerto.api.repositories.SubcategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private S3Service s3Service;

	@Autowired
	private ImageService imgService;

	@Autowired
	private MercadoPushRepository mercadoPushRepository;

	@Autowired
	private SubcategoriaRepository subcategoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Categoria> buscarCategorias() {
		return categoriaRepository.findAll();
	}

	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findByIdCategoria(id);

		if (categoria.isPresent())
			return categoria.get();
		return null;
	}

	public Categoria salvarCategoria(@Valid Categoria categoria) {

		return categoriaRepository.saveAndFlush(categoria);
	}

	public Categoria atualizarCategoria(Integer id, @Valid Categoria categoria) {
		Optional<Categoria> categoriaOp = categoriaRepository.findByIdCategoria(id);

		if (!categoriaOp.isPresent())
			throw new EmptyResultDataAccessException(1);

		return categoriaRepository.saveAndFlush(categoria);
	}

	public void deletarCategoria(Integer id) throws Exception {
		Categoria categoria = buscarPorId(id);
		if (mercadoPushRepository.findByCategoria(categoria).size() > 0 || produtoRepository.buscarProdutosPorCategoria(id).size() > 0) {
			throw new Exception("Categoria em uso. Não pode ser excluída!");
		}

		categoriaRepository.delete(id);
	}

	public URI uploadCategoriaPicture(MultipartFile multipartFile, Integer idcategoria) {

		String prefix = "cat" + idcategoria;
		System.out.println("minha categoria é" + idcategoria);

		BufferedImage jpgImage = imgService.getJpgImageFromFile(multipartFile);

		// pegar um prefixo de Cat + id da categoria referente + extensão
		String filename = prefix + ".jpg";

		return s3Service.uploadFile(imgService.getInputStream(jpgImage, "jpg"), filename, "image");
	}

}

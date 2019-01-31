package br.com.comprecerto.api.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.repositories.ProdutoRepository;
import br.com.comprecerto.api.repositories.SubcategoriaRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private SubcategoriaRepository subcategoriaRepository;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imgService;

	public List<Produto> buscarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Integer id) {
		Optional<Produto> produto = produtoRepository.findByIdProduto(id);

		if (produto.isPresent())
			return produto.get();

		return null;
	}

	public Produto salvarProduto(@Valid Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	public Produto atualizarProduto(Integer id, @Valid Produto produto) throws Exception {
		Optional<Produto> produtoOp = produtoRepository.findByIdProduto(id);

		if (!produtoOp.isPresent())
			throw new Exception("O produto informado não existe!");

		return salvarProduto(produto);
	}

	public void deletarProduto(Integer id) throws Exception {
		Optional<Produto> produtoOp = produtoRepository.findByIdProduto(id);

		if (!produtoOp.isPresent())
			throw new Exception("O produto informado não existe!");

		produtoRepository.delete(produtoOp.get());
	}

	public List<Produto> buscarProdutosPorCategoria(Integer idCategoria) {
		return produtoRepository.buscarProdutosPorCategoria(idCategoria);
	}

	public List<ProdutosAppDTO> listaProdutosDetail(ProdutosAppFilter produtosAppFilter) {
		return produtoRepository.listaProdutosDetail(produtosAppFilter);
	}

	public List<String> buscarMarcasPorSubcategoria(Integer idSubcategoria) throws Exception {
		Optional<Subcategoria> subcategoria = subcategoriaRepository.findByIdSubcategoria(idSubcategoria);
		
		if (!subcategoria.isPresent())
			throw new Exception("A categoria informada não existe!");
		
		return produtoRepository.buscarMarcasPorSubcategoria(subcategoria.get());
	}
	
	public URI uploadProdutoPicture(MultipartFile multipartFile, Integer idproduto) {
		
		String prefix = "prod"+ idproduto;
		
		BufferedImage jpgImage = imgService.getJpgImageFromFile(multipartFile);
		
		String filename = prefix + ".jpg";
		
		return s3Service.uploadFile(imgService.getInputStream(jpgImage, "jpg"), filename ,"image");
	}

}

package br.com.comprecerto.api.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.dto.ProdutoFilter;
import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;
import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.repositories.MercadoProdutoRepository;
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

	@Autowired
	private MercadoProdutoRepository mercadoProdutoRepository;

	public List<Produto> buscarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Integer id) throws Exception {
		Optional<Produto> produto = produtoRepository.findByIdProduto(id);

		if (!produto.isPresent())
			throw new Exception("O produto informado não existe!");

		return produto.get();
	}

	public Produto salvarProduto(@Valid Produto produto) throws Exception {

		Produto produtoSalvo = produtoRepository.saveAndFlush(produto);
		if (produtoSalvo.getImageBase64() != null && !produtoSalvo.getImageBase64().isEmpty()) {
			produtoSalvo.setImageBase64(produto.getImageBase64());
			produtoSalvo = uploadProdutoPicture(produtoSalvo);
		}

		return produtoSalvo;
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

		if (mercadoProdutoRepository.findByProduto(produtoOp.get()).size() > 0) {
			throw new Exception("O produto é utilizado em algum mercado! Não pode ser excluído");
		}

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

	public Produto uploadProdutoPicture(Produto produto) throws Exception {
		produto.setImagemUrl(
				imgService.salvaImagemFromBase64(produto.getImageBase64(), "produto-" + produto.getIdProduto()));
		return produtoRepository.saveAndFlush(produto);

	}

	public List<Map<String, String>> buscarUnidadesMedidaPorSubcategoriaEMarca(Integer idSubcategoria, String marca)
			throws Exception {
		Optional<Subcategoria> subcategoria = subcategoriaRepository.findByIdSubcategoria(idSubcategoria);

		if (!subcategoria.isPresent())
			throw new Exception("A categoria informada não existe!");

		List<Produto> produtos = produtoRepository.findBySubcategoriaAndMarca(subcategoria, marca);

		List<Map<String, String>> unidadesMedida = new ArrayList<Map<String, String>>();
		produtos.stream().forEach(produto -> {
			Map<String, String> unidadeMedida = new HashMap<String, String>();
			unidadeMedida.put("quantidade", produto.getQuantidade().toString());
			unidadeMedida.put("unidadeMedida", produto.getUnidadeMedida().getSigla());
			unidadesMedida.add(unidadeMedida);
		});

		return unidadesMedida;
	}

	public List<Produto> filtrar(ProdutoFilter filter) {
		return produtoRepository.filtrar(filter);
	}

}

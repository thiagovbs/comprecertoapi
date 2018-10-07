package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

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

}

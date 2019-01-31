package br.com.comprecerto.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.dto.ProdutoFilter;
import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> buscarProdutos() {
		return ResponseEntity.ok(produtoService.buscarProdutos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(produtoService.salvarProduto(produto));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable Integer id, @RequestBody @Valid Produto produto) {
		try {
			return ResponseEntity.ok(produtoService.atualizarProduto(id, produto));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarProduto(@PathVariable Integer id) {
		try {
			produtoService.deletarProduto(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/categoria/{idCategoria}")
	public ResponseEntity<List<Produto>> buscarProdutosPorCategoria(@PathVariable Integer idCategoria) {
		return ResponseEntity.ok(produtoService.buscarProdutosPorCategoria(idCategoria));
	}

	@PostMapping(value = "/detail")
	public ResponseEntity<List<ProdutosAppDTO>> listaProdutosDetail(@RequestBody ProdutosAppFilter produtosAppFilter) {
		return ResponseEntity.ok(produtoService.listaProdutosDetail(produtosAppFilter));
	}

	@GetMapping(value = "/marcas/subcategoria/{idSubcategoria}")
	public ResponseEntity<?> buscarMarcasPorSubcategoria(@PathVariable Integer idSubcategoria) {
		try {
			return ResponseEntity.ok(produtoService.buscarMarcasPorSubcategoria(idSubcategoria));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/marcas/subcategoria/{idSubcategoria}/marca/{marca}")
	public ResponseEntity<?> buscarUnidadesMedidaPorSubcategoriaEMarca(@PathVariable Integer idSubcategoria, @PathVariable String marca) {
		try {
			return ResponseEntity.ok(produtoService.buscarUnidadesMedidaPorSubcategoriaEMarca(idSubcategoria, marca));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping(value = "/filter")
	public ResponseEntity<?> filtrar(@RequestBody ProdutoFilter filter) {
		try {
			return ResponseEntity.ok(produtoService.filtrar(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

package br.com.comprecerto.api.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.config.CompreCertoExceptionHandler.Erro;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.services.MercadoProdutoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/mercado-produtos")
public class MercadoProdutoController {

	@Autowired
	private MercadoProdutoService service;

	@GetMapping
	public ResponseEntity<?> filtrar(MercadoProdutoFilter filter) {
		try {
			return ResponseEntity.ok(service.filtrar(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/dto")
	public ResponseEntity<?> filtrarDto(MercadoProdutoFilter filter) {
		try {
			return ResponseEntity.ok(service.filtrarDto(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/dto/com-validade")
	public ResponseEntity<?> filtrarDtoComValidade(MercadoProdutoFilter filter) {
		try {
			return ResponseEntity.ok(service.filtrarDtoComValidade(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> salvarMercadoProduto(@RequestBody @Valid MercadoProduto mercadoProduto) {
		try {			
			return ResponseEntity.ok(service.salvarMercadoProduto(mercadoProduto));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Arrays.asList(new Erro(e.getMessage(), e.getCause())));
		}
	}
	
	@PutMapping(value = "/{idMercadoProduto}")
	public ResponseEntity<?> atualizarProduto(@PathVariable Integer idMercadoProduto, @RequestBody @Valid MercadoProduto mercadoProduto) {
		try {
			return ResponseEntity.ok(service.atualizarProduto(idMercadoProduto, mercadoProduto));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@DeleteMapping(value = "/{id}")
	public void deletarProduto(@PathVariable Integer id) {
		try {
			service.deletarProduto(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

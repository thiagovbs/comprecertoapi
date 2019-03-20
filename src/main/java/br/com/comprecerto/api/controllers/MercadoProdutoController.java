package br.com.comprecerto.api.controllers;

import java.security.Principal;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.config.CompreCertoExceptionHandler.Erro;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.services.MercadoProdutoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/mercado-produtos")
public class MercadoProdutoController {

	@Autowired
	private MercadoProdutoService service;

	@PostMapping(value = "/filter")
	public ResponseEntity<?> filtrar(@RequestBody MercadoProdutoFilter filter) {
		try {
			return ResponseEntity.ok(service.filtrar(filter));
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
			return ResponseEntity.badRequest().body(Arrays.asList(new Erro(e.getMessage(), e.getCause().toString())));
		}
	}
	
	@GetMapping
	public ResponseEntity<?> buscarMercadoProdutos(Principal principal) {
		try {
			return ResponseEntity.ok(service.buscarMercadoProdutos(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(Arrays.asList(new Erro(e.getMessage(), e.getCause().toString())));
		}
	}
}


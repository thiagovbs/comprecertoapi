package br.com.comprecerto.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.services.MercadoProdutoService;

@RestController
@RequestMapping(value = "/mercado-produtos")
public class MercadoProdutoController {
	
	@Autowired
	private MercadoProdutoService mercadoProdutoService;

	@PostMapping(value = "/filter")
	public ResponseEntity<?> filtrar(@RequestBody MercadoProdutoFilter filter) {
		try {
			return ResponseEntity.ok(mercadoProdutoService.filtrar(filter));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

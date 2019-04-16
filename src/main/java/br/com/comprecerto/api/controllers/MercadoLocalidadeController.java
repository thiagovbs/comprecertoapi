package br.com.comprecerto.api.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.services.MercadoLocalidadeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/mercado-localidades")
public class MercadoLocalidadeController {

	@Autowired
	private MercadoLocalidadeService service;

	@GetMapping
	private ResponseEntity<?> buscarMercadoLocalides(Principal principal) {
		try {
			return ResponseEntity.ok(service.buscarMercadoLocalidades(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

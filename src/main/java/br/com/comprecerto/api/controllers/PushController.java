package br.com.comprecerto.api.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.services.MercadoPushService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/push")
public class PushController {

	@Autowired
	private MercadoPushService mercadoPushService;

	@GetMapping(value = "/hoje")
	public ResponseEntity<?> buscarPushsDeHoje(Principal principal) {
		try {
			return ResponseEntity.ok(mercadoPushService.buscarPushsDeHoje(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

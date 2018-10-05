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

import br.com.comprecerto.api.entities.MercadoPush;
import br.com.comprecerto.api.services.MercadoPushService;

@RestController
@RequestMapping(value = "/mercadoPushs")
public class MercadoPushController {

	@Autowired
	private MercadoPushService mercadoPushService;

	@GetMapping
	public ResponseEntity<List<MercadoPush>> buscarMercadoPushs() {
		return ResponseEntity.ok(mercadoPushService.buscarMercadoPushs());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MercadoPush> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(mercadoPushService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<MercadoPush> salvarMercadoPush(@RequestBody @Valid MercadoPush mercadoPush) {
		return ResponseEntity.ok(mercadoPushService.salvarMercadoPush(mercadoPush));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarMercadoPush(@PathVariable Integer id, @RequestBody @Valid MercadoPush mercadoPush) {
		try {
			return ResponseEntity.ok(mercadoPushService.atualizarMercadoPush(id, mercadoPush));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarMercadoPush(@PathVariable Integer id) {
		try {
			mercadoPushService.deletarMercadoPush(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

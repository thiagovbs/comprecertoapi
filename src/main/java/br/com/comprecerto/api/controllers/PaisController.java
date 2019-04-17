package br.com.comprecerto.api.controllers;

import java.util.List;

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

import br.com.comprecerto.api.entities.Pais;
import br.com.comprecerto.api.services.PaisService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/paises")
public class PaisController {

	@Autowired
	private PaisService paisService;

	@GetMapping
	public ResponseEntity<List<Pais>> buscarPaiss() {
		return ResponseEntity.ok(paisService.buscarPaiss());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pais> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(paisService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Pais> salvarPais(@RequestBody @Valid Pais pais) {
		return ResponseEntity.ok(paisService.salvarPais(pais));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarPais(@PathVariable Integer id, @RequestBody @Valid Pais pais) {
		try {
			return ResponseEntity.ok(paisService.atualizarPais(id, pais));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarPais(@PathVariable Integer id) {
		try {
			paisService.deletarPais(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

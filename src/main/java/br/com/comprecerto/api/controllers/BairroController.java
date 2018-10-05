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

import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.services.BairroService;

@RestController
@RequestMapping(value = "/bairros")
public class BairroController {

	@Autowired
	private BairroService bairroService;

	@GetMapping
	public ResponseEntity<List<Bairro>> buscarBairros() {
		return ResponseEntity.ok(bairroService.buscarBairros());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Bairro> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(bairroService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Bairro> salvarBairro(@RequestBody @Valid Bairro bairro) {
		return ResponseEntity.ok(bairroService.salvarBairro(bairro));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarBairro(@PathVariable Integer id, @RequestBody @Valid Bairro bairro) {
		try {
			return ResponseEntity.ok(bairroService.atualizarBairro(id, bairro));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarBairro(@PathVariable Integer id) {
		try {
			bairroService.deletarBairro(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

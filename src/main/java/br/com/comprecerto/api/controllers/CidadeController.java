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

import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeService cidadeService;

	@GetMapping
	public ResponseEntity<List<Cidade>> buscarCidades() {
		return ResponseEntity.ok(cidadeService.buscarCidades());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(cidadeService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Cidade> salvarCidade(@RequestBody @Valid Cidade cidade) {
		return ResponseEntity.ok(cidadeService.salvarCidade(cidade));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarCidade(@PathVariable Integer id, @RequestBody @Valid Cidade cidade) {
		try {
			return ResponseEntity.ok(cidadeService.atualizarCidade(id, cidade));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarCidade(@PathVariable Integer id) {
		try {
			cidadeService.deletarCidade(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

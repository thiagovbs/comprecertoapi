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

import br.com.comprecerto.api.entities.Permissao;
import br.com.comprecerto.api.services.PermissaoService;

@RestController
@RequestMapping(value = "/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoService permissaoService;

	@GetMapping
	public ResponseEntity<List<Permissao>> buscarPermissaos() {
		return ResponseEntity.ok(permissaoService.buscarPermissaos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Permissao> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(permissaoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Permissao> salvarPermissao(@RequestBody @Valid Permissao permissao) {
		return ResponseEntity.ok(permissaoService.salvarPermissao(permissao));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarPermissao(@PathVariable Integer id, @RequestBody @Valid Permissao permissao) {
		try {
			return ResponseEntity.ok(permissaoService.atualizarPermissao(id, permissao));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarPermissao(@PathVariable Integer id) {
		try {
			permissaoService.deletarPermissao(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

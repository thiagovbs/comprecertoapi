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

import br.com.comprecerto.api.entities.UsuarioLista;
import br.com.comprecerto.api.services.UsuarioListaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuarioListas")
public class UsuarioListaController {

	@Autowired
	private UsuarioListaService usuarioListaService;

	@GetMapping
	public ResponseEntity<List<UsuarioLista>> buscarUsuarioListas() {
		return ResponseEntity.ok(usuarioListaService.buscarUsuarioListas());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioLista> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(usuarioListaService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<UsuarioLista> salvarUsuarioLista(@RequestBody @Valid UsuarioLista usuarioLista) {
		return ResponseEntity.ok(usuarioListaService.salvarUsuarioLista(usuarioLista));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarUsuarioLista(@PathVariable Integer id, @RequestBody @Valid UsuarioLista usuarioLista) {
		try {
			return ResponseEntity.ok(usuarioListaService.atualizarUsuarioLista(id, usuarioLista));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarUsuarioLista(@PathVariable Integer id) {
		try {
			usuarioListaService.deletarUsuarioLista(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

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

import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarUsuarios() {
		return ResponseEntity.ok(usuarioService.buscarUsuarios());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(usuarioService.buscarPorId(id));
	}

	@GetMapping(value = "/login/{login}")
	public ResponseEntity<Usuario> buscarPorLogin(@PathVariable String login) {
		return ResponseEntity.ok(usuarioService.buscarPorLogin(login));
	}

	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid Usuario usuario) {
		
		return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable Integer id, @RequestBody @Valid Usuario usuario) {
		try {
			return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuario));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable Integer id) {
		try {
			usuarioService.deletarUsuario(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

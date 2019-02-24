package br.com.comprecerto.api.controllers;

import java.net.URI;
import java.security.Principal;
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
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.services.MercadoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;
	
	Mercado m = new Mercado();

	@GetMapping
	public ResponseEntity<List<Mercado>> buscarMercados() {
		return ResponseEntity.ok(mercadoService.buscarMercados());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Mercado> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(mercadoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Mercado> salvarMercado(@RequestBody @Valid Mercado mercado) {
		
		m = mercadoService.salvarMercado(mercado);
		return ResponseEntity.ok(m);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarMercado(@PathVariable Integer id, @RequestBody @Valid Mercado mercado) {
		try {
			
			m = mercadoService.atualizarMercado(id, mercado);
			
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> desativarMercado(@PathVariable Integer id) {
		try {
			mercadoService.desativarMercado(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/funcionario")
	public ResponseEntity<?> buscarPorFuncionario(Principal principal) {
		try {
			return ResponseEntity.ok(mercadoService.buscarPorFuncionario(principal));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping(value="/picture")
	public ResponseEntity<?> uploadProfilePicture(@PathVariable MultipartFile file) {
		
		URI uri = mercadoService.uploadMercadoPicture(file, m.getIdMercado());
		return ResponseEntity.created(uri).build();
	}
}

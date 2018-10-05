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

import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.services.MercadoService;

@RestController
@RequestMapping(value = "/mercados")
public class MercadoController {

	@Autowired
	private MercadoService mercadoService;

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
		return ResponseEntity.ok(mercadoService.salvarMercado(mercado));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarMercado(@PathVariable Integer id, @RequestBody @Valid Mercado mercado) {
		try {
			return ResponseEntity.ok(mercadoService.atualizarMercado(id, mercado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarMercado(@PathVariable Integer id) {
		try {
			mercadoService.deletarMercado(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

package br.com.comprecerto.api.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;
import javax.xml.ws.Response;

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

import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.services.EstadoService;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/estados")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public ResponseEntity<?> buscarEstados(Boolean fativo) {
		try {
			return ResponseEntity.ok(estadoService.buscarEstados(fativo));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(estadoService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Estado> salvarEstado(@RequestBody @Valid Estado estado) {
		return ResponseEntity.ok(estadoService.salvarEstado(estado));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarEstado(@PathVariable Integer id, @RequestBody @Valid Estado estado) {
		try {
			return ResponseEntity.ok(estadoService.atualizarEstado(id, estado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarEstado(@PathVariable Integer id) {
		try {
			estadoService.deletarEstado(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/mercado/{idMercado}")
	public ResponseEntity<?> buscarEstados(@PathVariable Integer idMercado) {
		try {
			return ResponseEntity.ok(estadoService.buscarEstadosPorMercado(idMercado));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

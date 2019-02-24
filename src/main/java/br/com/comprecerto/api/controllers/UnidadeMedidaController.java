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

import br.com.comprecerto.api.entities.UnidadeMedida;
import br.com.comprecerto.api.services.UnidadeMedidaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/unidadesMedida")
public class UnidadeMedidaController {

	@Autowired
	private UnidadeMedidaService unidadeMedidaService;

	@GetMapping
	public ResponseEntity<List<UnidadeMedida>> buscarUnidadesMedida() {
		return ResponseEntity.ok(unidadeMedidaService.buscarUnidadesMedida());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<UnidadeMedida> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(unidadeMedidaService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<UnidadeMedida> salvarUnidadeMedida(@RequestBody @Valid UnidadeMedida categoria) {
		return ResponseEntity.ok(unidadeMedidaService.salvarUnidadeMedida(categoria));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarCategoria(@PathVariable Integer id, @RequestBody @Valid UnidadeMedida categoria) {
		try {
			return ResponseEntity.ok(unidadeMedidaService.atualizarUnidadeMedida(id, categoria));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletarCategoria(@PathVariable Integer id) {
		try {
			unidadeMedidaService.deletarUnidadeMedida(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping(value = "/buscarPorSubcategoria/{idSubcategoria}")
	public ResponseEntity<List<UnidadeMedida>> buscarUnidadesMedidaPorSubcategoria(
			@PathVariable Integer idSubcategoria) {
		return ResponseEntity.ok(unidadeMedidaService.buscarUnidadesMedidaPorSubcategoria(idSubcategoria));
	}
}

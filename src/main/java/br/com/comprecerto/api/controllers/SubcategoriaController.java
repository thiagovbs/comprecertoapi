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

import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.services.SubcategoriaService;

@RestController
@RequestMapping(value = "/subcategorias")
public class SubcategoriaController {

	@Autowired
	private SubcategoriaService subcategoriaService;

	@GetMapping
	public ResponseEntity<List<Subcategoria>> buscarSubcategorias() {
		return ResponseEntity.ok(subcategoriaService.buscarSubcategorias());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Subcategoria> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(subcategoriaService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Subcategoria> salvarSubcategoria(@RequestBody @Valid Subcategoria subcategoria) {
		return ResponseEntity.ok(subcategoriaService.salvarSubcategoria(subcategoria));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarSubcategoria(@PathVariable Integer id, @RequestBody @Valid Subcategoria subcategoria) {
		try {
			return ResponseEntity.ok(subcategoriaService.atualizarSubcategoria(id, subcategoria));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deletarSubcategoria(@PathVariable Integer id) {
		try {
			subcategoriaService.deletarSubcategoria(id);

			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}

package br.com.comprecerto.api.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	private Categoria cat = new Categoria();

	@GetMapping
	public ResponseEntity<List<Categoria>> buscarCategorias() {
		return ResponseEntity.ok(categoriaService.buscarCategorias());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(categoriaService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<?> salvarCategoria(@RequestBody @Valid Categoria categoria) {
		if (categoria.getIdCategoria() != null) {
			return ResponseEntity.badRequest().body("Para alterações deve ser usado o protocolo PUT");
		}
		
		cat = categoriaService.salvarCategoria(categoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> atualizarCategoria(@PathVariable Integer id, @RequestBody @Valid Categoria categoria) {
		
		cat = categoriaService.atualizarCategoria(id, categoria);
		
		return ResponseEntity.ok(cat);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarCategoria(@PathVariable Integer id) {
		categoriaService.deletarCategoria(id);
	}
	
	@PostMapping(value="/picture")
	public ResponseEntity<?> uploadProfilePicture(@PathVariable MultipartFile file) {
		
		URI uri = categoriaService.uploadCategoriaPicture(file, cat.getIdCategoria());
		return ResponseEntity.created(uri).build();
	}
}

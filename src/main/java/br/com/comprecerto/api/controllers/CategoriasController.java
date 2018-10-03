package br.com.comprecerto.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriasController {
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public List<Categoria> buscarCategorias() {
		return categoriaService.buscarCategorias();
	}
}

package br.com.comprecerto.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> buscarCategorias() {
		return categoriaRepository.findAll();
	}

}

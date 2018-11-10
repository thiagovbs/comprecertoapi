package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findByIdCategoria(id);

		if (categoria.isPresent())
			return categoria.get();

		return null;
	}

	public Categoria salvarCategoria(@Valid Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}

	public Categoria atualizarCategoria(Integer id, @Valid Categoria categoria) {
		Optional<Categoria> categoriaOp = categoriaRepository.findByIdCategoria(id);

		if (!categoriaOp.isPresent())
			throw new EmptyResultDataAccessException(1);

		BeanUtils.copyProperties(categoria, categoriaOp.get(), "idCategoria");
		return salvarCategoria(categoria);
	}

	public void deletarCategoria(Integer id) {
		categoriaRepository.delete(id);
	}

}

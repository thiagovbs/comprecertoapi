package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);

		if (categoria.isPresent())
			return categoria.get();

		return null;
	}

	public Categoria salvarCategoria(@Valid Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}

	public Categoria atualizarCategoria(Integer id, @Valid Categoria categoria) throws Exception {
		Optional<Categoria> categoriaOp = categoriaRepository.findById(id);

		if (!categoriaOp.isPresent())
			throw new Exception("A categoria informada não existe!");

		return salvarCategoria(categoria);
	}

	public void deletarCategoria(Integer id) throws Exception {
		Optional<Categoria> categoriaOp = categoriaRepository.findById(id);

		if (!categoriaOp.isPresent())
			throw new Exception("A categoria informada não existe!");

		categoriaRepository.delete(categoriaOp.get());
	}

}

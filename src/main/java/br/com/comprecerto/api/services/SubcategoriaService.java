package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.repositories.SubcategoriaRepository;

@Service
public class SubcategoriaService {

	@Autowired
	private SubcategoriaRepository subCategoriaRepository;

	public List<Subcategoria> buscarSubcategorias() {
		return subCategoriaRepository.findAll();
	}

	public Subcategoria buscarPorId(Integer id) {
		Optional<Subcategoria> subCategoria = subCategoriaRepository.findById(id);

		if (subCategoria.isPresent())
			return subCategoria.get();

		return null;
	}

	public Subcategoria salvarSubcategoria(@Valid Subcategoria subCategoria) {
		return subCategoriaRepository.saveAndFlush(subCategoria);
	}

	public Subcategoria atualizarSubcategoria(Integer id, @Valid Subcategoria subCategoria) throws Exception {
		Optional<Subcategoria> subCategoriaOp = subCategoriaRepository.findById(id);

		if (!subCategoriaOp.isPresent())
			throw new Exception("A subcategoria informada não existe!");

		return salvarSubcategoria(subCategoria);
	}

	public void deletarSubcategoria(Integer id) throws Exception {
		Optional<Subcategoria> subCategoriaOp = subCategoriaRepository.findById(id);

		if (!subCategoriaOp.isPresent())
			throw new Exception("A subcategoria informada não existe!");

		subCategoriaRepository.delete(subCategoriaOp.get());
	}

}

package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.repositories.CategoriaRepository;
import br.com.comprecerto.api.repositories.SubcategoriaRepository;

@Service
public class SubcategoriaService {

	@Autowired
	private SubcategoriaRepository subCategoriaRepository;
	
	@Autowired CategoriaRepository categoriaRepository;

	public List<Subcategoria> buscarSubcategorias() {
		return subCategoriaRepository.findAll();
	}

	public Subcategoria buscarPorId(Integer id) {
		Optional<Subcategoria> subCategoria = subCategoriaRepository.findByIdSubcategoria(id);

		if (subCategoria.isPresent())
			return subCategoria.get();

		return null;
	}

	public Subcategoria salvarSubcategoria(@Valid Subcategoria subCategoria) {
		return subCategoriaRepository.saveAndFlush(subCategoria);
	}

	public Subcategoria atualizarSubcategoria(Integer id, @Valid Subcategoria subCategoria) throws Exception {
		Optional<Subcategoria> subCategoriaOp = subCategoriaRepository.findByIdSubcategoria(id);

		if (!subCategoriaOp.isPresent())
			throw new Exception("A subcategoria informada não existe!");

		return salvarSubcategoria(subCategoria);
	}

	public void deletarSubcategoria(Integer id) throws Exception {
		Optional<Subcategoria> subCategoriaOp = subCategoriaRepository.findByIdSubcategoria(id);

		if (!subCategoriaOp.isPresent())
			throw new Exception("A subcategoria informada não existe!");

		subCategoriaRepository.delete(subCategoriaOp.get());
	}

	public List<Subcategoria> buscarSubcategoriasByCategoria(Integer idCategoria) throws Exception {
		Optional<Categoria> categoria = categoriaRepository.findByIdCategoria(idCategoria);
		
		if (!categoria.isPresent())
			throw new Exception("A categoria informada não encontrada!");
		
		return subCategoriaRepository.findByCategoria(categoria.get());
	}

}

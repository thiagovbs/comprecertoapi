package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	Optional<Categoria> findByIdCategoria(Integer id);

	@Query("from Categoria c join c.subcategorias sc where sc.idSubcategoria = ?1")
	Categoria buscarPorSubcategoria(Integer idSubcategoria);

}

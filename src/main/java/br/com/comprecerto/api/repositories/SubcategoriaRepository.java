package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Subcategoria;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {

	Optional<Subcategoria> findByIdSubcategoria(Integer id);

}

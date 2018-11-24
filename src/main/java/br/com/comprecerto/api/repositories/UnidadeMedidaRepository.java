package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.UnidadeMedida;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Integer> {

	Optional<UnidadeMedida> findByIdUnidade(Integer id);

	@Query("select um from UnidadeMedida um join um.categorias c join c.subcategorias sc where sc.idSubcategoria = ?1")
	List<UnidadeMedida> buscarUnidadesMedidaPorSubcategoria(Integer idSubcategoria);

}

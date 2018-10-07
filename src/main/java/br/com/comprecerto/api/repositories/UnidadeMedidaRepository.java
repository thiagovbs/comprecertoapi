package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.UnidadeMedida;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Integer> {

	Optional<UnidadeMedida> findByIdUnidade(Integer id);

}

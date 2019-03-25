package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.MercadoLocalidade;

@Repository
public interface MercadoLocalidadeRepository extends JpaRepository<MercadoLocalidade, Integer> {

	Optional<MercadoLocalidade> findByIdMercadoLocalidade(Integer idMercadoLocalidade);

}
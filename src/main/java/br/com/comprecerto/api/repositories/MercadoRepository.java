package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Mercado;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Integer> {

	Optional<Mercado> findByIdMercado(Integer id);

}

package br.com.comprecerto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Mercado;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Integer> {

}

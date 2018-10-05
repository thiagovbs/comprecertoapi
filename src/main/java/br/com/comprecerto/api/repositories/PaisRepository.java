package br.com.comprecerto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}

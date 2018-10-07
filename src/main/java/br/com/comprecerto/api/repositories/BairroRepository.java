package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

	Optional<Bairro> findByIdBairro(Integer id);

}

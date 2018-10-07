package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.UsuarioLista;

@Repository
public interface UsuarioListaRepository extends JpaRepository<UsuarioLista, Integer> {

	Optional<UsuarioLista> findByIdUsuarioLista(Integer id);

}

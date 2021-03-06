package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Integer> {

	Optional<Permissao> findByIdPermissao(Integer id);

    Permissao findByDescricao(String descricao);
}

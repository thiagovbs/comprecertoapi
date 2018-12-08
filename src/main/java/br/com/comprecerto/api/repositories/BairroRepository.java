package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

	Optional<Bairro> findByIdBairro(Integer id);

    Bairro findByNome(String nome);

    @Query("select b from Bairro b" +
            " where b.nome = ?1.nome" +
            " and b.cidade.nome = ?1.cidade.nome" +
            " and (b.cidade.estado.nome = ?1.cidade.estado.nome or b.cidade.estado.sigla = ?1.cidade.estado.sigla)" +
            " and (b.cidade.estado.pais.nome = ?1.cidade.estado.pais.nome or b.cidade.estado.pais.sigla = ?1.cidade.estado.pais.sigla)")
    Bairro findByNomeAndCidadeAndEstadoAndPais(Bairro bairro);
}

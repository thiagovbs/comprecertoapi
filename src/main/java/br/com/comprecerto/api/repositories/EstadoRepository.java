package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import br.com.comprecerto.api.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

	Optional<Estado> findByIdEstado(Integer id);

//	@Query("select e from Estado e" + //
//			" where e.nome = ?1.nome" + //
//			" and e.nome = ?1.nome" + //
//			" and e.pais.nome = ?1.pais.nome")
//	Estado findByNomeAndPais(Estado estado);

	@Query("select e from Estado e" + //
			" where e.nome = ?1" + //
			" and e.pais.nome = ?2")
	Estado findByNomeAndPais(String nome, String nomePais);

	@Query("select e from Estado e join e.cidades c join c.bairros b join b.mercadoLocalidades ml where ml.mercado.idMercado = ?1")
    List<Estado> findByMercado(Integer mercado);
}

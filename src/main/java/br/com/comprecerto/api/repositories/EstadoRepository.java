package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

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
	
	@Query("select e from Estado e" + //
			" where e.sigla = ?1")
	Estado findBySigla(String nome);

	@Query("select DISTINCT e from Estado e join e.cidades c join c.bairros b join b.mercadoLocalidades ml where ml.mercado.idMercado = ?1 and ml.fAtivo=true")
    List<Estado> findByMercado(Integer idMercado);
	
	@Query("SELECT DISTINCT e FROM Estado e JOIN e.cidades c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE ml.fAtivo=true")	
    List<Estado> AllWithMercadoAtivo();
	
	@Query("SELECT DISTINCT e FROM Estado e JOIN e.cidades c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE ml.fAtivo=true or ml.fAtivo=false")	
    List<Estado> AllWithMercadoAll();
}

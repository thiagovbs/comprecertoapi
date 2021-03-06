package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.entities.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	Optional<Cidade> findByIdCidade(Integer id);

	Cidade findByNome(String nome);

//	@Query("select c from Cidade c" + //
//			" where c.nome = ?1.nome" + //
//			" and c.estado.nome = ?1.estado.nome" + //
//			" and c.estado.pais.nome = ?1.estado.pais.nome")
//	Cidade findByNomeAndEstadoAndPais(Cidade cidade);

	@Query("select c from Cidade c" + //
			" where c.nome = ?1" + //
			" and c.estado.nome = ?2" + //
			" and c.estado.pais.nome = ?3")
	Cidade findByNomeAndEstadoAndPais(String nome, String nomeEstado, String nomePais);

	List<Cidade> findByEstado(Estado estado);
	
	@Query("SELECT DISTINCT c FROM Estado e JOIN e.cidades c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE ml.fAtivo=true and e.idEstado=?1")	
    List<Cidade> AllWithMercadoAtivo(Integer IdEstado);
	
	@Query("SELECT DISTINCT c FROM Estado e JOIN e.cidades c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE (ml.fAtivo=true or ml.fAtivo=false) and e.idEstado=?1")	
    List<Cidade> AllWithMercadoAll(Integer IdEstado);
	
	@Query("SELECT DISTINCT c FROM Estado e JOIN e.cidades c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE e.idEstado=?1 and ml.mercado.idMercado=?2 and ml.fAtivo=true")	
    List<Cidade> AllbyEstadoMercado(Integer IdEstado, Integer IdMercado);
}

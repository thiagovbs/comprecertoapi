package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Cidade;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {

	Optional<Bairro> findByIdBairro(Integer id);

	Bairro findByNome(String nome);

//	@Query("select b from Bairro b" + //
//			" where b.nome = ?1.nome" + //
//			" and b.cidade.nome = ?1.cidade.nome" + //
//			" and b.cidade.estado.nome = ?1.cidade.estado.nome" + //
//			" and b.cidade.estado.pais.nome = ?1.cidade.estado.pais.nome")
//	Bairro findByNomeAndCidadeAndEstadoAndPais(Bairro bairro);

	@Query("select b from Bairro b" + //
			" where b.nome = ?1" + //
			" and b.cidade.nome = ?2" + //
			" and b.cidade.estado.nome = ?3" + //
			" and b.cidade.estado.pais.nome = ?4")
	Bairro findByNomeAndCidadeAndEstadoAndPais(String nome, String nomeCidade, String nomeEstado, String nomePais);

	List<Bairro> findByCidade(Cidade cidade);
	
	@Query("SELECT DISTINCT b FROM Cidade c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE ml.fAtivo=true and c.idCidade=?1")	
    List<Bairro> AllWithMercadoAtivo(Integer IdCidade);
	
	@Query("SELECT DISTINCT b FROM Cidade c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE c.idCidade=?1 and (ml.fAtivo=true or ml.fAtivo=false)")	
    List<Bairro> AllWithMercadoAll(Integer IdCidade);
	
	@Query("SELECT DISTINCT b FROM Cidade c JOIN c.bairros b JOIN b.mercadoLocalidades ml WHERE c.idCidade=?1 and ml.mercado.idMercado=?2 and ml.fAtivo=true")	
    List<Bairro> AllbyCidadeMercado(Integer IdCidade, Integer IdMercado);
}

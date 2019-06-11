package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.entities.MercadoLocalidade;

@Repository
public interface MercadoLocalidadeRepository extends JpaRepository<MercadoLocalidade, Integer> {

	Optional<MercadoLocalidade> findByIdMercadoLocalidade(Integer idMercadoLocalidade);

	List<MercadoLocalidade> findByMercado(Mercado mercado);
	
	@Transactional
	@Modifying
	@Query("update MercadoLocalidade ml set ml.fAtivo = false where ml.idMercadoLocalidade = ?1")
	void desativar(Integer idMercadoLocalidade);

}

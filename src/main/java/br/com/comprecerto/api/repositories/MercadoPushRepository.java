package br.com.comprecerto.api.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.MercadoPush;

@Repository
public interface MercadoPushRepository extends JpaRepository<MercadoPush, Integer> {

	@Query("select mp from MercadoPush mp where mp.mercado.idMercado = ?1 and date(dataHoraExibicao) >= current_date and date(dataValidade) <= current_date")
	List<MercadoPush> findHojeByMercado(Integer idMercado);

}

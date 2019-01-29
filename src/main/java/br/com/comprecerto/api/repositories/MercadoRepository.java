package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.comprecerto.api.entities.Mercado;

@Repository
public interface MercadoRepository extends JpaRepository<Mercado, Integer> {

	Optional<Mercado> findByIdMercado(Integer id);

	@Transactional
	@Modifying
	@Query("update Mercado m set m.fAtivo = false where m.idMercado = ?1")
	void desativar(Integer idMercado);

}

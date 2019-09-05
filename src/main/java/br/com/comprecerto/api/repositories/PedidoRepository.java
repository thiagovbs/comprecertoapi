package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	Optional<Pedido> findByIdPedido(Integer id);

	@Query("from Pedido p where p.usuario.idUsuario = ?1 order by p.idPedido")
	List<Pedido> findByIdUsuario(Integer idUsuario);
	
	@Query("from Pedido p where p.mercadoLocalidade.idMercadoLocalidade = ?1 order by p.idPedido")
	List<Pedido> findByIdMercadoLocalidade(Integer idMercadoLocalidade);
	
	@Query("from Pedido p where p.mercadoLocalidade.mercado.idMercado = ?1 order by p.idPedido")
	List<Pedido> findByIdMercado(Integer idMercado);

}

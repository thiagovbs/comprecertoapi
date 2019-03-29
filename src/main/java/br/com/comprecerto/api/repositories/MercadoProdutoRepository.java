package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.repositories.mercadoProduto.MercadoProdutoRepositoryQuery;

@Repository
public interface MercadoProdutoRepository extends JpaRepository<MercadoProduto, Integer>, MercadoProdutoRepositoryQuery {

	@Query("from MercadoProduto mp where mp.mercadoLocalidade.mercado = ?1")
	List<MercadoProduto> findAllByMercado(Mercado mercado);

	List<Produto> findByProduto(Produto produto);

	Optional<MercadoProduto> findByIdMercadoProduto(Integer idMercadoProduto);

}

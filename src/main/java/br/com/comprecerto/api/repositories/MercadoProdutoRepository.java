package br.com.comprecerto.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.repositories.mercadoProduto.MercadoProdutoRepositoryQuery;

@Repository
public interface MercadoProdutoRepository extends JpaRepository<MercadoProduto, Integer>, MercadoProdutoRepositoryQuery {

}

package br.com.comprecerto.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.PedidoProduto;
import br.com.comprecerto.api.entities.Servico;

@Repository
public interface PedidoProdutoRepository extends JpaRepository<PedidoProduto, Integer> {

	

}

package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	Optional<Produto> findByIdProduto(Integer id);

	@Query("from Produto p where p.subcategoria.categoria.idCategoria = ?1")
	List<Produto> buscarProdutosPorCategoria(Integer idCategoria);

}

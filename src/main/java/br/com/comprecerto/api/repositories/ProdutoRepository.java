package br.com.comprecerto.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.repositories.produto.ProdutoRepositoryQuery;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoRepositoryQuery {

	Optional<Produto> findByIdProduto(Integer id);

	@Query("from Produto p where p.subcategoria.categoria.idCategoria = ?1")
	List<Produto> buscarProdutosPorCategoria(Integer idCategoria);
	
	@Query("from Produto p where p.subcategoria.idSubcategoria = ?1")
	List<Produto> buscarProdutosPorSubCategoria(Integer idSubcategoria);

	@Query("select distinct p.marca from Produto p where p.subcategoria = ?1")
	List<String> buscarMarcasPorSubcategoria(Subcategoria subcategoria);

	List<Produto> findBySubcategoriaAndMarca(Optional<Subcategoria> subcategoria, String marca);

}

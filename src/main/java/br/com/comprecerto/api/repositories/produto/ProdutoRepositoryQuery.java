package br.com.comprecerto.api.repositories.produto;

import java.util.List;

import br.com.comprecerto.api.dto.ProdutoFilter;
import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;
import br.com.comprecerto.api.entities.Produto;

public interface ProdutoRepositoryQuery {

	List<ProdutosAppDTO> listaProdutosDetail(ProdutosAppFilter produtosAppFilter);
	
	List<Produto> filtrar(ProdutoFilter filter);
}

package br.com.comprecerto.api.repositories.produto;

import java.util.List;

import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;

public interface ProdutoRepositoryQuery {

	List<ProdutosAppDTO> listaProdutosDetail(ProdutosAppFilter produtosAppFilter);
}

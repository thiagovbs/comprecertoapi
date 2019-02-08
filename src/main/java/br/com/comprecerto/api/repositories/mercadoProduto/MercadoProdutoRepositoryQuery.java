package br.com.comprecerto.api.repositories.mercadoProduto;

import java.util.List;

import br.com.comprecerto.api.dto.MercadoProdutoDTO;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;

public interface MercadoProdutoRepositoryQuery {

	public List<MercadoProdutoDTO> filtrar(MercadoProdutoFilter filter);
}

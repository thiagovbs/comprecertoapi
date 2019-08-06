package br.com.comprecerto.api.repositories.mercadoProduto;

import java.util.List;

import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.dto.MercadoProdutoFilter2;
import br.com.comprecerto.api.entities.MercadoProduto;

public interface MercadoProdutoRepositoryQuery {

	public List<MercadoProduto> filtrar(MercadoProdutoFilter filter);
	
	public List<MercadoProduto> filtrar2(MercadoProdutoFilter2 filter);
	
}

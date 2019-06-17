package br.com.comprecerto.api.repositories.mercado;

import br.com.comprecerto.api.dto.LocalidadeFilter;
import br.com.comprecerto.api.entities.Mercado;

import java.util.List;

public interface MercadoRepositoryQuery {

    public List<Mercado> buscarMercados(LocalidadeFilter localidadeFilter, Boolean fativo);
}

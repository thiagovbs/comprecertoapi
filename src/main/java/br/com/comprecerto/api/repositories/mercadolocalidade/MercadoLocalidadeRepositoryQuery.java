package br.com.comprecerto.api.repositories.mercadolocalidade;

import br.com.comprecerto.api.entities.MercadoLocalidade;

import java.util.List;

public interface MercadoLocalidadeRepositoryQuery {

    public List<MercadoLocalidade> buscarMercadosLocalidadePorBairro(Integer idBairro);
}

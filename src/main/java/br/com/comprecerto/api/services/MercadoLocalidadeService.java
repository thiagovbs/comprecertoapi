package br.com.comprecerto.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.repositories.MercadoLocalidadeRepository;

@Service
public class MercadoLocalidadeService {

	@Autowired
	private MercadoLocalidadeRepository repository;

	public MercadoLocalidade buscarMercadoLocalidade(Integer idMercadoLocalidade) throws Exception {
		Optional<MercadoLocalidade> mercadoLocalidade = repository.findByIdMercadoLocalidade(idMercadoLocalidade);

		if (!mercadoLocalidade.isPresent())
			throw new Exception("Mercado localidade informado não existe!");

		return mercadoLocalidade.get();
	}
}

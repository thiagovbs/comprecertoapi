package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.MercadoPush;
import br.com.comprecerto.api.repositories.MercadoPushRepository;

@Service
public class MercadoPushService {

	@Autowired
	private MercadoPushRepository mercadoPushRepository;

	public List<MercadoPush> buscarMercadoPushs() {
		return mercadoPushRepository.findAll();
	}

	public MercadoPush buscarPorId(Integer id) {
		Optional<MercadoPush> mercadoPush = mercadoPushRepository.findById(id);

		if (mercadoPush.isPresent())
			return mercadoPush.get();

		return null;
	}

	public MercadoPush salvarMercadoPush(@Valid MercadoPush mercadoPush) {
		return mercadoPushRepository.saveAndFlush(mercadoPush);
	}

	public MercadoPush atualizarMercadoPush(Integer id, @Valid MercadoPush mercadoPush) throws Exception {
		Optional<MercadoPush> mercadoPushOp = mercadoPushRepository.findById(id);

		if (!mercadoPushOp.isPresent())
			throw new Exception("O mercado push informado não existe!");

		return salvarMercadoPush(mercadoPush);
	}

	public void deletarMercadoPush(Integer id) throws Exception {
		Optional<MercadoPush> mercadoPushOp = mercadoPushRepository.findById(id);

		if (!mercadoPushOp.isPresent())
			throw new Exception("O mercado push informado não existe!");

		mercadoPushRepository.delete(mercadoPushOp.get());
	}

}

package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.UnidadeMedida;
import br.com.comprecerto.api.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {

	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;

	public List<UnidadeMedida> buscarUnidadesMedida() {
		return unidadeMedidaRepository.findAll();
	}

	public UnidadeMedida buscarPorId(Integer id) {
		Optional<UnidadeMedida> unidadeMedida = unidadeMedidaRepository.findByIdUnidade(id);

		if (unidadeMedida.isPresent())
			return unidadeMedida.get();

		return null;
	}

	public UnidadeMedida salvarUnidadeMedida(@Valid UnidadeMedida unidadeMedida) {
		return unidadeMedidaRepository.saveAndFlush(unidadeMedida);
	}

	public UnidadeMedida atualizarUnidadeMedida(Integer id, @Valid UnidadeMedida unidadeMedida) throws Exception {
		Optional<UnidadeMedida> unidadeMedidaOp = unidadeMedidaRepository.findByIdUnidade(id);

		if (!unidadeMedidaOp.isPresent())
			throw new Exception("A unidade medida informada não existe!");

		return salvarUnidadeMedida(unidadeMedida);
	}

	public void deletarUnidadeMedida(Integer id) throws Exception {
		Optional<UnidadeMedida> unidadeMedidaOp = unidadeMedidaRepository.findByIdUnidade(id);

		if (!unidadeMedidaOp.isPresent())
			throw new Exception("A unidade medida informada não existe!");

		unidadeMedidaRepository.delete(unidadeMedidaOp.get());
	}
	
}

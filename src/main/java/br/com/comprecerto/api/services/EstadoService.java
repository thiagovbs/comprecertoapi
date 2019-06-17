package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> buscarEstados(Boolean fativo) {
		System.out.print(fativo);
		if(fativo)
			return estadoRepository.AllWithMercadoAtivo();
		else
			return estadoRepository.AllWithMercadoAll();
	}

	public Estado buscarPorId(Integer id) {
		Optional<Estado> estado = estadoRepository.findByIdEstado(id);

		if (estado.isPresent())
			return estado.get();

		return null;
	}

	public Estado salvarEstado(@Valid Estado estado) {
		return estadoRepository.saveAndFlush(estado);
	}

	public Estado atualizarEstado(Integer id, @Valid Estado estado) throws Exception {
		Optional<Estado> estadoOp = estadoRepository.findByIdEstado(id);

		if (!estadoOp.isPresent())
			throw new Exception("O estado informado não existe!");

		return salvarEstado(estado);
	}

	public void deletarEstado(Integer id) throws Exception {
		Optional<Estado> estadoOp = estadoRepository.findByIdEstado(id);

		if (!estadoOp.isPresent())
			throw new Exception("O estado informado não existe!");

		estadoRepository.delete(estadoOp.get());
	}

	public List<Estado> buscarEstadosPorMercado(Integer idMercado) throws Exception {
		return estadoRepository.findByMercado(idMercado);
	}
}

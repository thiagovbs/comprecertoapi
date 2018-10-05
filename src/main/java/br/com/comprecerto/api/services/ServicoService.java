package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Servico;
import br.com.comprecerto.api.repositories.ServicoRepository;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository servicoRepository;

	public List<Servico> buscarServicos() {
		return servicoRepository.findAll();
	}

	public Servico buscarPorId(Integer id) {
		Optional<Servico> servico = servicoRepository.findById(id);

		if (servico.isPresent())
			return servico.get();

		return null;
	}

	public Servico salvarServico(@Valid Servico servico) {
		return servicoRepository.saveAndFlush(servico);
	}

	public Servico atualizarServico(Integer id, @Valid Servico servico) throws Exception {
		Optional<Servico> servicoOp = servicoRepository.findById(id);

		if (!servicoOp.isPresent())
			throw new Exception("O servico informado não existe!");

		return salvarServico(servico);
	}

	public void deletarServico(Integer id) throws Exception {
		Optional<Servico> servicoOp = servicoRepository.findById(id);

		if (!servicoOp.isPresent())
			throw new Exception("O servico informado não existe!");

		servicoRepository.delete(servicoOp.get());
	}

}

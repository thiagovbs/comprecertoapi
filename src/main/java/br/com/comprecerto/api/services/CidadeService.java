package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Cidade> buscarCidades() {
		return cidadeRepository.findAll();
	}

	public Cidade buscarPorId(Integer id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);

		if (cidade.isPresent())
			return cidade.get();

		return null;
	}

	public Cidade salvarCidade(@Valid Cidade cidade) {
		return cidadeRepository.saveAndFlush(cidade);
	}

	public Cidade atualizarCidade(Integer id, @Valid Cidade cidade) throws Exception {
		Optional<Cidade> cidadeOp = cidadeRepository.findById(id);

		if (!cidadeOp.isPresent())
			throw new Exception("A cidade informada não existe!");

		return salvarCidade(cidade);
	}

	public void deletarCidade(Integer id) throws Exception {
		Optional<Cidade> cidadeOp = cidadeRepository.findById(id);

		if (!cidadeOp.isPresent())
			throw new Exception("A cidade informada não existe!");

		cidadeRepository.delete(cidadeOp.get());
	}

}

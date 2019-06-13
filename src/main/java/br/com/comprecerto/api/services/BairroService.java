package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.repositories.BairroRepository;
import br.com.comprecerto.api.repositories.CidadeRepository;

@Service
public class BairroService {

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	public List<Bairro> buscarBairros() {
		return bairroRepository.findAll();
	}

	public Bairro buscarPorId(Integer id) {
		Optional<Bairro> bairro = bairroRepository.findByIdBairro(id);

		if (bairro.isPresent())
			return bairro.get();

		return null;
	}

	public Bairro salvarBairro(@Valid Bairro bairro) {
		return bairroRepository.saveAndFlush(bairro);
	}

	public Bairro atualizarBairro(Integer id, @Valid Bairro bairro) throws Exception {
		Optional<Bairro> bairroOp = bairroRepository.findByIdBairro(id);

		if (!bairroOp.isPresent())
			throw new Exception("A bairro informada não existe!");

		return salvarBairro(bairro);
	}

	public void deletarBairro(Integer id) throws Exception {
		Optional<Bairro> bairroOp = bairroRepository.findByIdBairro(id);

		if (!bairroOp.isPresent())
			throw new Exception("A bairro informada não existe!");

		bairroRepository.delete(bairroOp.get());
	}

	public List<Bairro> buscarBairrosPorCidade(Integer idCidade) throws Exception {
		Optional<Cidade> cidade = cidadeRepository.findByIdCidade(idCidade);

		if (!cidade.isPresent())
			throw new Exception("A cidade informada não existe!");

		return bairroRepository.AllWithMercado(cidade.get().getIdCidade());
	}

}

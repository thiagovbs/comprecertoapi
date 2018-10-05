package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Pais;
import br.com.comprecerto.api.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository paisRepository;

	public List<Pais> buscarPaiss() {
		return paisRepository.findAll();
	}

	public Pais buscarPorId(Integer id) {
		Optional<Pais> pais = paisRepository.findById(id);

		if (pais.isPresent())
			return pais.get();

		return null;
	}

	public Pais salvarPais(@Valid Pais pais) {
		return paisRepository.saveAndFlush(pais);
	}

	public Pais atualizarPais(Integer id, @Valid Pais pais) throws Exception {
		Optional<Pais> paisOp = paisRepository.findById(id);

		if (!paisOp.isPresent())
			throw new Exception("O país informado não existe!");

		return salvarPais(pais);
	}

	public void deletarPais(Integer id) throws Exception {
		Optional<Pais> paisOp = paisRepository.findById(id);

		if (!paisOp.isPresent())
			throw new Exception("O país informado não existe!");

		paisRepository.delete(paisOp.get());
	}

}

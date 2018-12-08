package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Mercado;

@Service
public class MercadoService {

	@Autowired
	private MercadoRepository mercadoRepository;
	
	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	public List<Mercado> buscarMercados() {
		return mercadoRepository.findAll();
	}

	public Mercado buscarPorId(Integer id) {
		Optional<Mercado> mercado = mercadoRepository.findByIdMercado(id);

		if (mercado.isPresent())
			return mercado.get();

		return null;
	}

	public Mercado salvarMercado(@Valid Mercado mercado) {
		mercado.getMercadoLocalidades().forEach(localidade -> {
			Bairro bairro = bairroRepository.findByNomeAndCidadeAndEstadoAndPais(localidade.getBairro());
		});
		return mercadoRepository.saveAndFlush(mercado);
	}

	public Mercado atualizarMercado(Integer id, @Valid Mercado mercado) throws Exception {
		Optional<Mercado> mercadoOp = mercadoRepository.findByIdMercado(id);

		if (!mercadoOp.isPresent())
			throw new Exception("O mercado informado não existe!");

		return salvarMercado(mercado);
	}

	public void deletarMercado(Integer id) throws Exception {
		Optional<Mercado> mercadoOp = mercadoRepository.findByIdMercado(id);

		if (!mercadoOp.isPresent())
			throw new Exception("O mercado informado não existe!");

		mercadoRepository.delete(mercadoOp.get());
	}

}

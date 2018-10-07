package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Permissao;
import br.com.comprecerto.api.repositories.PermissaoRepository;

@Service
public class PermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	public List<Permissao> buscarPermissaos() {
		return permissaoRepository.findAll();
	}

	public Permissao buscarPorId(Integer id) {
		Optional<Permissao> permissao = permissaoRepository.findByIdPermissao(id);

		if (permissao.isPresent())
			return permissao.get();

		return null;
	}

	public Permissao salvarPermissao(@Valid Permissao permissao) {
		return permissaoRepository.saveAndFlush(permissao);
	}

	public Permissao atualizarPermissao(Integer id, @Valid Permissao permissao) throws Exception {
		Optional<Permissao> permissaoOp = permissaoRepository.findByIdPermissao(id);

		if (!permissaoOp.isPresent())
			throw new Exception("O usuário informado não existe!");

		return salvarPermissao(permissao);
	}

	public void deletarPermissao(Integer id) throws Exception {
		Optional<Permissao> permissaoOp = permissaoRepository.findByIdPermissao(id);

		if (!permissaoOp.isPresent())
			throw new Exception("O usuário informado não existe!");

		permissaoRepository.delete(permissaoOp.get());
	}

}

package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.UsuarioLista;
import br.com.comprecerto.api.repositories.UsuarioListaRepository;

@Service
public class UsuarioListaService {

	@Autowired
	private UsuarioListaRepository usuarioListaRepository;

	public List<UsuarioLista> buscarUsuarioListas() {
		return usuarioListaRepository.findAll();
	}

	public UsuarioLista buscarPorId(Integer id) {
		Optional<UsuarioLista> usuarioLista = usuarioListaRepository.findByIdUsuarioLista(id);

		if (usuarioLista.isPresent())
			return usuarioLista.get();

		return null;
	}

	public UsuarioLista salvarUsuarioLista(@Valid UsuarioLista usuarioLista) {
		return usuarioListaRepository.saveAndFlush(usuarioLista);
	}

	public UsuarioLista atualizarUsuarioLista(Integer id, @Valid UsuarioLista usuarioLista) throws Exception {
		Optional<UsuarioLista> usuarioListaOp = usuarioListaRepository.findByIdUsuarioLista(id);

		if (!usuarioListaOp.isPresent())
			throw new Exception("O usuário lista informado não existe!");

		return salvarUsuarioLista(usuarioLista);
	}

	public void deletarUsuarioLista(Integer id) throws Exception {
		Optional<UsuarioLista> usuarioListaOp = usuarioListaRepository.findByIdUsuarioLista(id);

		if (!usuarioListaOp.isPresent())
			throw new Exception("O usuário lista informado não existe!");

		usuarioListaRepository.delete(usuarioListaOp.get());
	}

}

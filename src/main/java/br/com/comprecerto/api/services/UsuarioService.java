package br.com.comprecerto.api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EmailService emailService;

	public List<Usuario> buscarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findByIdUsuario(id);

		if (usuario.isPresent())
			return usuario.get();

		return null;
	}

	public Usuario salvarUsuario(@Valid Usuario usuario) {
		Usuario userResp = usuarioRepository.saveAndFlush(usuario);
//		emailService.sendConfirmationEmail(usuario);

		return userResp;
	}

	public Usuario atualizarUsuario(Integer id, @Valid Usuario usuario) throws Exception {
		Optional<Usuario> usuarioOp = usuarioRepository.findByIdUsuario(id);

		if (!usuarioOp.isPresent())
			throw new Exception("O usuário informado não existe!");

		return salvarUsuario(usuario);
	}

	public void deletarUsuario(Integer id) throws Exception {
		Optional<Usuario> usuarioOp = usuarioRepository.findByIdUsuario(id);

		if (!usuarioOp.isPresent())
			throw new Exception("O usuário informado não existe!");

		usuarioRepository.delete(usuarioOp.get());
	}

	public Usuario buscarPorLogin(String login) {
		return usuarioRepository.findByLogin(login).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	public Usuario buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email).orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

}

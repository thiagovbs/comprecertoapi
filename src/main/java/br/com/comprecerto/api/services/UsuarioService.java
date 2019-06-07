package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.comprecerto.api.entities.Permissao;
import br.com.comprecerto.api.repositories.PermissaoRepository;
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

	@Autowired
	private PermissaoRepository permissaoRepository;

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
		// emailService.sendConfirmationEmail(usuario);

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

	public Optional<Usuario> buscarPorEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

	public Permissao buscarPermissao(String descricao) {
		return permissaoRepository.findByDescricao(descricao);
	}

	public void excluirPorEmailAndName(String email, String nomeFantasia) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailAndNome(email, nomeFantasia);
		usuarioOptional.get().getIdUsuario();
		if (usuarioOptional.isPresent()) {			
			usuarioRepository.deleteRelacionamento(usuarioOptional.get().getIdUsuario());			
			usuarioRepository.delete(usuarioOptional.get().getIdUsuario());
		}
	}

	public void desativaUsuarioPorEmailAndNome(String email, String nomeFantasia) {
		usuarioRepository.desativaUsuarioPorEmailAndNome(email, nomeFantasia);
	}

	public boolean isAdmin(Principal principal) throws Exception {
		Optional<Usuario> usuarioLogado = usuarioRepository.findByLogin(principal.getName());

		if (!usuarioLogado.isPresent())
			throw new Exception("Usuário não encontrado!");

		return usuarioLogado.get().isAdmin();
	}
}

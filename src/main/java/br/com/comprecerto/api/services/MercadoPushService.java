package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.MercadoPush;
import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.repositories.MercadoPushRepository;
import br.com.comprecerto.api.repositories.UsuarioRepository;

@Service
public class MercadoPushService {

	@Autowired
	private MercadoPushRepository mercadoPushRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<MercadoPush> buscarPushsDeHoje(Principal principal) throws Exception {
		Optional<Usuario> usuarioLogado = usuarioRepository.findByLogin(principal.getName());

		if (!usuarioLogado.isPresent())
			throw new Exception("Usuário não encontrado!");

		return mercadoPushRepository.findHojeByMercado(usuarioLogado.get().getMercado().getIdMercado());
	}

}

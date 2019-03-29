package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.repositories.MercadoLocalidadeRepository;

@Service
public class MercadoLocalidadeService {

	@Autowired
	private MercadoLocalidadeRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;

	public MercadoLocalidade buscarMercadoLocalidade(Integer idMercadoLocalidade) throws Exception {
		Optional<MercadoLocalidade> mercadoLocalidade = repository.findByIdMercadoLocalidade(idMercadoLocalidade);

		if (!mercadoLocalidade.isPresent())
			throw new Exception("Mercado localidade informado não existe!");

		return mercadoLocalidade.get();
	}

	public List<MercadoLocalidade> buscarMercadoLocalidades(Principal principal) throws Exception {
		Optional<Usuario> usuario = usuarioService.buscarPorLogin(principal.getName());
		
		if (!usuario.isPresent()) {
			throw new Exception("Usuário não encontrado!");
		}
		
		if (usuario.get().isAdmin()) {
			return repository.findAll();
		}
		
		return repository.findByMercado(usuario.get().getMercado());
	}
}

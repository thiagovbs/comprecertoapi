package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.repositories.MercadoLocalidadeRepository;
import br.com.comprecerto.api.repositories.mercadolocalidade.MercadoLocalidadeRepositoryQuery;

@Service
public class MercadoLocalidadeService {

	@Autowired
	private MercadoLocalidadeRepository repository;
	
	@Autowired
	private MercadoLocalidadeRepositoryQuery repositoryQuery;

	@Autowired
	private UsuarioService usuarioService;

	public MercadoLocalidade buscarMercadoLocalidade(Integer idMercadoLocalidade) throws Exception {
		Optional<MercadoLocalidade> mercadoLocalidade = repository.findByIdMercadoLocalidade(idMercadoLocalidade);

		if (!mercadoLocalidade.isPresent())
			throw new Exception("Mercado localidade informado não existe!");

		return mercadoLocalidade.get();
	}

	public List<MercadoLocalidade> buscarMercadoLocalidades(Principal principal) throws Exception {
		Usuario usuario = usuarioService.buscarPorLogin(principal.getName());

		if (usuario.isAdmin()) {
			return repository.findAll();
		}

		return repository.findByMercado(usuario.getMercado());
	}
	
	public List<MercadoLocalidade> buscarMercadoLocalidadePorBairro(Integer idBairro) throws Exception {
		return repositoryQuery.buscarMercadosLocalidadePorBairro(idBairro);
	}
	
	@Transactional
	public void desativarMercadoLocalidade(Integer idMercadoLocalidade) throws Exception {
		Optional<MercadoLocalidade> mercadoLocalidade = repository.findByIdMercadoLocalidade(idMercadoLocalidade);

		if (!mercadoLocalidade.isPresent())
			throw new Exception("Mercado localidade informado não existe!");

		repository.desativar(mercadoLocalidade.get().getIdMercadoLocalidade());
	}
}

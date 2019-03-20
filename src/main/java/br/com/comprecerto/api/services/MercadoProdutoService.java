package br.com.comprecerto.api.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprecerto.api.dto.MercadoProdutoDTO;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.entities.Usuario;
import br.com.comprecerto.api.repositories.MercadoProdutoRepository;
import br.com.comprecerto.api.repositories.UsuarioRepository;

@Service
public class MercadoProdutoService {

	@Autowired
	private MercadoProdutoRepository repository;

	@Autowired
	private MercadoLocalidadeService mercadoLocalidadeService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<MercadoProdutoDTO> filtrar(MercadoProdutoFilter filter) {
		return repository.filtrar(filter);
	}

	public MercadoProduto salvarMercadoProduto(MercadoProduto mercadoProduto) throws Exception {
		mercadoLocalidadeService.buscarMercadoLocalidade(mercadoProduto.getMercadoLocalidade().getIdMercadoLocalidade());
		produtoService.buscarPorId(mercadoProduto.getProduto().getIdProduto());

		return repository.saveAndFlush(mercadoProduto);
	}

	public List<MercadoProduto> buscarMercadoProdutos(Principal principal) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(principal.getName());
		if (!usuario.isPresent())
			throw new Exception("O usuário logado não foi encontrado!");

		return repository.findAllByMercado(usuario.get().getMercado());
	}

}

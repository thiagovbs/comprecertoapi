package br.com.comprecerto.api.services;

import java.security.Principal;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<MercadoProduto> filtrar(MercadoProdutoFilter filter) {
		return repository.filtrar(filter);
	}

	public MercadoProduto salvarMercadoProduto(MercadoProduto mercadoProduto) throws Exception {
		mercadoLocalidadeService.buscarMercadoLocalidade(mercadoProduto.getMercadoLocalidade().getIdMercadoLocalidade());
		produtoService.buscarPorId(mercadoProduto.getProduto().getIdProduto());
		
		if (!mercadoProduto.getDtEntrada().getDayOfWeek().equals(DayOfWeek.TUESDAY) && !mercadoProduto.getDtEntrada().getDayOfWeek().equals(DayOfWeek.FRIDAY))
			throw new Exception("A data de entrada devem ser na Terça-feira ou Sexta-feira!");
		
		if (mercadoProduto.getDtEntrada().getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
			mercadoProduto.setDtValidade(mercadoProduto.getDtEntrada().plusDays(2));
		} else if (mercadoProduto.getDtEntrada().getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
			mercadoProduto.setDtValidade(mercadoProduto.getDtEntrada().plusDays(3));
		}

		return repository.saveAndFlush(mercadoProduto);
	}

	public List<MercadoProduto> buscarMercadoProdutos(Principal principal) throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByLogin(principal.getName());
		if (!usuario.isPresent())
			throw new Exception("O usuário logado não foi encontrado!");

		return repository.findAllByMercado(usuario.get().getMercado());
	}

	public Object atualizarProduto(Integer idMercadoProduto, MercadoProduto mercadoProduto) throws Exception {
		Optional<MercadoProduto> mercadoProdutoOp = repository.findByIdMercadoProduto(idMercadoProduto);

		if (!mercadoProdutoOp.isPresent())
			throw new Exception("O produto informado não existe!");

		return salvarMercadoProduto(mercadoProduto);
	}

}

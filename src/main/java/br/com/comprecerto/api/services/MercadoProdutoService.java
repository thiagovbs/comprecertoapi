package br.com.comprecerto.api.services;

import java.security.Principal;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.comprecerto.api.dto.MercadoProdutoDTO;
import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.util.DateUtil;
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
		System.out.println(mercadoProduto.getProduto());
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
	
	public void deletarProduto(Integer idMercadoProduto) throws Exception {
		Optional<MercadoProduto> mercadoProdutoOp = repository.findByIdMercadoProduto(idMercadoProduto);

		if (!mercadoProdutoOp.isPresent())
			throw new Exception("O produto informado não existe!");

		repository.delete(idMercadoProduto);
	}

	public List<MercadoProdutoDTO> filtrarDto(MercadoProdutoFilter filter) {
		return criaProjecao(repository.filtrar(filter));
	}

	public List<MercadoProdutoDTO> criaProjecao(List<MercadoProduto> mercadoProdutos) {
		List<MercadoProdutoDTO> dtos = new ArrayList<>();

		for (MercadoProduto mercadoProduto : mercadoProdutos) {
			MercadoProdutoDTO dto = new MercadoProdutoDTO();
			dto.setIdMercadoProduto(mercadoProduto.getIdMercadoProduto());
			dto.setDtValidadeMercadoProduto(DateUtil.converteLocalDateToDate(mercadoProduto.getDtValidade()));
			dto.setPrecoMercadoProduto(mercadoProduto.getPreco());
			dto.setfDestaqueMercadoProduto(mercadoProduto.getFDestaque());
			dto.setObservacao(mercadoProduto.getObservacao());
			dto.setCaracteristicaProduto(mercadoProduto.getProduto().getCaracteristica());
			dto.setIdProduto(mercadoProduto.getProduto().getIdProduto());
			dto.setNomeProduto(mercadoProduto.getProduto().getNome());
			dto.setMarcaProduto(mercadoProduto.getProduto().getMarca());
			dto.setQuantidadeProduto(mercadoProduto.getProduto().getQuantidade());
			dto.setIdCategoria(mercadoProduto.getProduto().getSubcategoria().getCategoria().getIdCategoria());
			dto.setNomeCategoria(mercadoProduto.getProduto().getSubcategoria().getCategoria().getNome());
			dto.setIdSubcategoria(mercadoProduto.getProduto().getSubcategoria().getIdSubcategoria());
			dto.setNomeSubcategoria(mercadoProduto.getProduto().getSubcategoria().getNome());
			dto.setUnidadeMedida(mercadoProduto.getProduto().getUnidadeMedida().getSigla());
			dto.setIdMercadoLocalidade(mercadoProduto.getMercadoLocalidade().getIdMercadoLocalidade());
			dto.setIdMercado(mercadoProduto.getMercadoLocalidade().getMercado().getIdMercado());
			dto.setNomeFantasiaMercado(mercadoProduto.getMercadoLocalidade().getMercado().getNomeFantasia());
			dto.setRazaoSocialMercado(mercadoProduto.getMercadoLocalidade().getMercado().getRazaoSocial());
			dto.setIdBairro(mercadoProduto.getMercadoLocalidade().getBairro().getIdBairro());
			dto.setNomeBairro(mercadoProduto.getMercadoLocalidade().getBairro().getNome());
			dto.setIdCidade(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getIdCidade());
			dto.setNomeCidade(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getNome());
			dto.setIdEstado(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getIdEstado());
			dto.setNomeEstado(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getNome());
			dto.setIdPais(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getPais().getIdPais());
			dto.setNomePais(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getPais().getNome());
			dto.setMercadoServicos(mercadoProduto.getMercadoLocalidade().getMercadoServicos());
			dtos.add(dto);
		}

		return dtos;
	}

	public List<MercadoProdutoDTO> filtrarDtoComValidade(MercadoProdutoFilter filter) {
		filter.setComValidade(true);

		return filtrarDto(filter);
	}

	public boolean verificaPossuiProdutos(Mercado mercado) {
		Long count = repository.countByMercado(mercado);
		if (count > 0) {
			return true;
		}

		return false;
	}
}

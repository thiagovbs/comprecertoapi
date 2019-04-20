package br.com.comprecerto.api.repositories.mercadoProduto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.comprecerto.api.util.DateUtil;
import br.com.comprecerto.api.dto.MercadoProdutoDTO;
import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.entities.Mercado;
import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.entities.Subcategoria;

@Repository
public class MercadoProdutoRepositoryImpl implements MercadoProdutoRepositoryQuery {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<MercadoProduto> filtrar(MercadoProdutoFilter mercadoProdutoFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MercadoProduto> cq = cb.createQuery(MercadoProduto.class);

		Root<MercadoProduto> mercadoProduto = cq.from(MercadoProduto.class);
		List<Predicate> predicates = new ArrayList<>();

		verificaFiltros(cb, mercadoProduto, predicates, mercadoProdutoFilter);

		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

	private void verificaFiltros(CriteriaBuilder cb, Root<MercadoProduto> mercadoProduto, List<Predicate> predicates, MercadoProdutoFilter mercadoProdutoFilter) {
		if (mercadoProdutoFilter.getIdEstado() != null && mercadoProdutoFilter.getIdEstado() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
			Join<Bairro, Cidade> cidade = bairro.join("cidade");
			Join<Cidade, Estado> estado = cidade.join("estado");

			predicates.add(cb.equal(estado.get("idEstado"), mercadoProdutoFilter.getIdEstado()));
		}

		if (mercadoProdutoFilter.getIdCidade() != null && mercadoProdutoFilter.getIdCidade() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
			Join<Bairro, Cidade> cidade = bairro.join("cidade");

			predicates.add(cb.equal(cidade.get("idCidade"), mercadoProdutoFilter.getIdCidade()));
		}

		if (mercadoProdutoFilter.getIdBairro() != null && mercadoProdutoFilter.getIdBairro() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");

			predicates.add(cb.equal(bairro.get("idBairro"), mercadoProdutoFilter.getIdBairro()));
		}

		if (mercadoProdutoFilter.getIdCategoria() != null && mercadoProdutoFilter.getIdCategoria() != 0) {
			Join<MercadoProduto, Produto> produto = mercadoProduto.join("produto");
			Join<Produto, Subcategoria> subcategoria = produto.join("subcategoria");
			Join<Subcategoria, Categoria> categoria = subcategoria.join("categoria");

			predicates.add(cb.equal(categoria.get("idCategoria"), mercadoProdutoFilter.getIdCategoria()));
		}

		if (mercadoProdutoFilter.getIdSubcategoria() != null && mercadoProdutoFilter.getIdSubcategoria() != 0) {
			Join<MercadoProduto, Produto> produto = mercadoProduto.join("produto");
			Join<Produto, Subcategoria> subcategoria = produto.join("subcategoria");

			predicates.add(cb.equal(subcategoria.get("idSubcategoria"), mercadoProdutoFilter.getIdSubcategoria()));
		}

		if (mercadoProdutoFilter.getIdMercado() != null && mercadoProdutoFilter.getIdMercado() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");
			Join<Produto, Mercado> mercado = mercadoLocalidade.join("mercado");

			predicates.add(cb.equal(mercado.get("idMercado"), mercadoProdutoFilter.getIdMercado()));
		}

		if (mercadoProdutoFilter.getDtAlteracao() != null) {
			predicates.add(cb.equal(mercadoProduto.get("dtAlteracao"), mercadoProdutoFilter.getDtAlteracao()));
		}

		if (mercadoProdutoFilter.getIdMercadoLocalidade() != null && mercadoProdutoFilter.getIdMercadoLocalidade() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");

			predicates.add(cb.equal(mercadoLocalidade.get("idMercadoLocalidade"), mercadoProdutoFilter.getIdMercadoLocalidade()));
		}

		if (mercadoProdutoFilter.getDtEntrada() != null) {
			predicates.add(cb.equal(mercadoProduto.get("dtEntrada"), mercadoProdutoFilter.getDtEntrada()));
		}
	}

	@SuppressWarnings("unused")
	private List<MercadoProdutoDTO> criaProjecao(List<MercadoProduto> mercadoProdutos) {
		List<MercadoProdutoDTO> dtos = new ArrayList<>();

		for (MercadoProduto mercadoProduto : mercadoProdutos) {
			MercadoProdutoDTO dto = new MercadoProdutoDTO();
			dto.setCaracteristicaProduto(mercadoProduto.getProduto().getCaracteristica());
			dto.setIdCategoria(mercadoProduto.getProduto().getSubcategoria().getCategoria().getIdCategoria());
			dto.setIdSubcategoria(mercadoProduto.getProduto().getSubcategoria().getIdSubcategoria());
			dto.setIdProduto(mercadoProduto.getProduto().getIdProduto());
			dto.setNomeProduto(mercadoProduto.getProduto().getNome());
			dto.setMarcaProduto(mercadoProduto.getProduto().getMarca());
			dto.setNomeCategoria(mercadoProduto.getProduto().getNome());
			dto.setNomeSubcategoria(mercadoProduto.getProduto().getSubcategoria().getNome());
			dto.setQuantidadeProduto(mercadoProduto.getProduto().getQuantidade());
			dto.setUnidadeMedida(mercadoProduto.getProduto().getUnidadeMedida().getSigla());
			dto.setDtValidadeMercadoProduto(DateUtil.converteLocalDateToDate(mercadoProduto.getDtValidade()));
			dto.setPrecoMercadoProduto(mercadoProduto.getPreco());
			dto.setIdMercado(mercadoProduto.getMercadoLocalidade().getMercado().getIdMercado());
			dto.setNomeFantasiaMercado(mercadoProduto.getMercadoLocalidade().getMercado().getNomeFantasia());
			dto.setRazaoSocialMercado(mercadoProduto.getMercadoLocalidade().getMercado().getRazaoSocial());
			dto.setIdMercadoLocalidade(mercadoProduto.getMercadoLocalidade().getIdMercadoLocalidade());
			dto.setIdBairro(mercadoProduto.getMercadoLocalidade().getBairro().getIdBairro());
			dto.setNomeBairro(mercadoProduto.getMercadoLocalidade().getBairro().getNome());
			dto.setIdCidade(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getIdCidade());
			dto.setNomeCidade(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getNome());
			dto.setIdEstado(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getIdEstado());
			dto.setNomeEstado(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getNome());
			dto.setIdPais(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getPais().getIdPais());
			dto.setNomePais(mercadoProduto.getMercadoLocalidade().getBairro().getCidade().getEstado().getPais().getNome());
			dto.setObservacao(mercadoProduto.getObservacao());

			dtos.add(dto);
		}

		return dtos;
	}

}

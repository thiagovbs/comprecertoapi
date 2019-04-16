package br.com.comprecerto.api.repositories.produto;

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

import br.com.comprecerto.api.DateUtil;
import br.com.comprecerto.api.dto.ProdutoFilter;
import br.com.comprecerto.api.dto.ProdutosAppDTO;
import br.com.comprecerto.api.dto.ProdutosAppFilter;
import br.com.comprecerto.api.entities.Bairro;
import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.entities.Cidade;
import br.com.comprecerto.api.entities.Estado;
import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.entities.MercadoProduto;
import br.com.comprecerto.api.entities.Produto;
import br.com.comprecerto.api.entities.Subcategoria;
import br.com.comprecerto.api.entities.UnidadeMedida;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ProdutosAppDTO> listaProdutosDetail(ProdutosAppFilter produtosAppFilter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);

		Root<Produto> produto = cq.from(Produto.class);
		List<Predicate> predicates = new ArrayList<>();

		verificaFiltrosApp(cb, produto, predicates, produtosAppFilter);

		cq.where(predicates.toArray(new Predicate[0]));

		List<Produto> produtos = em.createQuery(cq).getResultList();
		return criaProjecao(produtos);
	}

	private void verificaFiltrosApp(CriteriaBuilder cb, Root<Produto> produto, List<Predicate> predicates, ProdutosAppFilter produtosAppFilter) {
		if (produtosAppFilter.getIdEstado() != null && produtosAppFilter.getIdEstado() != 0) {
			Join<Produto, MercadoProduto> mercadoProduto = produto.join("mercadoProdutos");
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoProduto");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
			Join<Bairro, Cidade> cidade = bairro.join("cidade");
			Join<Cidade, Estado> estado = cidade.join("estado");

			predicates.add(cb.equal(estado.get("idEstado"), produtosAppFilter.getIdEstado()));
		}

		if (produtosAppFilter.getIdCidade() != null && produtosAppFilter.getIdCidade() != 0) {
			Join<Produto, MercadoProduto> mercadoProduto = produto.join("mercadoProdutos");
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoProduto");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
			Join<Bairro, Cidade> cidade = bairro.join("cidade");

			predicates.add(cb.equal(cidade.get("idCidade"), produtosAppFilter.getIdCidade()));
		}

		if (produtosAppFilter.getIdBairro() != null && produtosAppFilter.getIdBairro() != 0) {
			Join<Produto, MercadoProduto> mercadoProduto = produto.join("mercadoProdutos");
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoProduto");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");

			predicates.add(cb.equal(bairro.get("idBairro"), produtosAppFilter.getIdBairro()));
		}

		if (produtosAppFilter.getIdCategoria() != null && produtosAppFilter.getIdCategoria() != 0) {
			Join<Produto, Subcategoria> subcategoria = produto.join("subcategoria");
			Join<Subcategoria, Categoria> categoria = subcategoria.join("categoria");

			predicates.add(cb.equal(categoria.get("idCategoria"), produtosAppFilter.getIdCategoria()));
		}

		if (produtosAppFilter.getIdSubcategoria() != null && produtosAppFilter.getIdSubcategoria() != 0) {
			Join<Produto, Subcategoria> subcategoria = produto.join("subcategoria");

			predicates.add(cb.equal(subcategoria.get("idSubcategoria"), produtosAppFilter.getIdSubcategoria()));
		}
	}

	private List<ProdutosAppDTO> criaProjecao(List<Produto> produtos) {
		List<ProdutosAppDTO> dtos = new ArrayList<>();

		for (Produto produto : produtos) {
			ProdutosAppDTO dto = new ProdutosAppDTO();
			dto.setCaracteristicaProduto(produto.getCaracteristica());
			dto.setIdCategoria(produto.getSubcategoria().getCategoria().getIdCategoria());
			dto.setIdSubcategoria(produto.getSubcategoria().getIdSubcategoria());
			dto.setIdProduto(produto.getIdProduto());
			dto.setMarcaProduto(produto.getMarca());
			dto.setNomeCategoria(produto.getNome());
			dto.setNomeSubcategoria(produto.getSubcategoria().getNome());
			dto.setQuantidadeProduto(produto.getQuantidade());
			dto.setUnidadeMedida(produto.getUnidadeMedida().getSigla());

			if (produto.getMercadoProdutos().size() != 0) {
				dto.setDtValidadeMercadoProduto(DateUtil.converteLocalDateToDate(produto.getMercadoProdutos().get(0).getDtValidade()));
				dto.setPrecoMercadoProduto(produto.getMercadoProdutos().get(0).getPreco());
			}

			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public List<Produto> filtrar(ProdutoFilter filter) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);

		Root<Produto> produto = cq.from(Produto.class);
		List<Predicate> predicates = new ArrayList<>();

		verificaFiltros(cb, produto, predicates, filter);

		cq.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(cq).getResultList();
	}

	private void verificaFiltros(CriteriaBuilder cb, Root<Produto> produto, List<Predicate> predicates, ProdutoFilter filter) {
		if (filter.getCategoria() != null) {
			Join<Produto, Subcategoria> produtoSubcategoria = produto.join("subcategoria");

			predicates.add(cb.equal(produtoSubcategoria.get("categoria"), filter.getCategoria()));
		}

		if (filter.getSubcategoria() != null) {
			predicates.add(cb.equal(produto.get("subcategoria"), filter.getSubcategoria()));
		}

		if (filter.getMarca() != null && !filter.getMarca().isEmpty()) {
			predicates.add(cb.equal(produto.get("marca"), filter.getMarca()));
		}

		if (filter.getUnidadeMedida() != null) {
			predicates.add(cb.equal(produto.get("quantidade"), Integer.parseInt(filter.getUnidadeMedida().get("quantidade").toString())));

			Join<Produto, UnidadeMedida> produtoUnidadeMedida = produto.join("unidadeMedida");
			predicates.add(cb.equal(produtoUnidadeMedida.get("sigla"), filter.getUnidadeMedida().get("unidadeMedida").toString()));
		}
	}

}

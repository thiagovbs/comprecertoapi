package br.com.comprecerto.api.repositories.mercadoProduto;

import br.com.comprecerto.api.dto.MercadoProdutoFilter;
import br.com.comprecerto.api.dto.MercadoProdutoFilter2;
import br.com.comprecerto.api.entities.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		
		Order fdestaque = cb.desc(mercadoProduto.get("fDestaque"));
		Order preco = cb.asc(mercadoProduto.get("preco"));
	    cq.orderBy(fdestaque,preco);
		cq.where(predicates.toArray(new Predicate[0]));
			
		
		if(mercadoProdutoFilter.getCount() !=null && mercadoProdutoFilter.getPage() != null ) {
			int count = mercadoProdutoFilter.getCount();
			int page = mercadoProdutoFilter.getCount()*mercadoProdutoFilter.getPage();
			return em.createQuery(cq).setMaxResults(count).setFirstResult(page).getResultList();
		}else {
			return em.createQuery(cq).getResultList();
		}
	}
	
	@Override
	public List<MercadoProduto> filtrar2(MercadoProdutoFilter2 mercadoProdutoFilter) {
				
		CriteriaBuilder cb = em.getCriteriaBuilder();		
		CriteriaQuery<MercadoProduto> cq = cb.createQuery(MercadoProduto.class);

		Root<MercadoProduto> mercadoProduto = cq.from(MercadoProduto.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		verificaFiltros2(cb, mercadoProduto, predicates, mercadoProdutoFilter);
		
		Order fdestaque = cb.desc(mercadoProduto.get("fDestaque"));
		Order preco = cb.asc(mercadoProduto.get("preco"));
	    cq.orderBy(fdestaque,preco);
		cq.where(predicates.toArray(new Predicate[0]));
			
		
		if(mercadoProdutoFilter.getCount() !=null && mercadoProdutoFilter.getPage() != null ) {
			int count = mercadoProdutoFilter.getCount();
			int page = mercadoProdutoFilter.getCount()*mercadoProdutoFilter.getPage();
			return em.createQuery(cq).setMaxResults(count).setFirstResult(page).getResultList();
		}else {
			return em.createQuery(cq).getResultList();
		}
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

		if (mercadoProdutoFilter.getComValidade() != null && mercadoProdutoFilter.getComValidade()) {
			predicates.add(cb.greaterThanOrEqualTo(mercadoProduto.get("dtValidade"), LocalDate.now()));
			//predicates.add(cb.lessThanOrEqualTo(mercadoProduto.get("dtEntrada"), LocalDate.now()));
		}			
			
	}
	
	private void verificaFiltros2(CriteriaBuilder cb, Root<MercadoProduto> mercadoProduto, List<Predicate> predicates, MercadoProdutoFilter2 mercadoProdutoFilter) {
		if (mercadoProdutoFilter.getIdEstado() != null && mercadoProdutoFilter.getIdEstado() != 0) {
			Join<MercadoProduto, MercadoLocalidade> mercadoLocalidade = mercadoProduto.join("mercadoLocalidade");
			Join<MercadoLocalidade, Bairro> bairro = mercadoLocalidade.join("bairro");
			Join<Bairro, Cidade> cidade = bairro.join("cidade");
			Join<Cidade, Estado> estado = cidade.join("estado");

			predicates.add(cb.equal(estado.get("idEstado"), mercadoProdutoFilter.getIdEstado()));
		}
		
		if (mercadoProdutoFilter.getNome() != null && mercadoProdutoFilter.getNome() != "") {
			Join<MercadoProduto, Produto> produto = mercadoProduto.join("produto");		
			predicates.add(cb.like(produto.get("nome"),"%"+ mercadoProdutoFilter.getNome()+"%"));
		}
		
		if (mercadoProdutoFilter.getMarca() != null && mercadoProdutoFilter.getMarca() != "") {
			Join<MercadoProduto, Produto> produto = mercadoProduto.join("produto");			
			predicates.add(cb.like(produto.get("marca"),"%"+ mercadoProdutoFilter.getMarca()+"%"));
		}
		
		if (mercadoProdutoFilter.getCaracteristica() != null && mercadoProdutoFilter.getCaracteristica() != "") {
			Join<MercadoProduto, Produto> produto = mercadoProduto.join("produto");			
			predicates.add(cb.like(produto.get("caracteristica"),"%"+ mercadoProdutoFilter.getCaracteristica()+"%"));
		}
		
		if (mercadoProdutoFilter.getObservacao() != null && mercadoProdutoFilter.getObservacao() != "") {						
			predicates.add(cb.like(mercadoProduto.get("observacao"), "%" + mercadoProdutoFilter.getObservacao()+"%"));
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

		if (mercadoProdutoFilter.getComValidade() != null && mercadoProdutoFilter.getComValidade()) {
			predicates.add(cb.greaterThanOrEqualTo(mercadoProduto.get("dtValidade"), LocalDate.now()));
			//predicates.add(cb.lessThanOrEqualTo(mercadoProduto.get("dtEntrada"), LocalDate.now()));
		}			
			
	}

}

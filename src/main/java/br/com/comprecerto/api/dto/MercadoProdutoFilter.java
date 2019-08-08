package br.com.comprecerto.api.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

public class MercadoProdutoFilter extends ProdutosAppFilter {

	private Integer idMercado;
	private Integer page;
	private Integer count;
	private LocalDate dtAlteracao;
	private LocalDate dtEntrada;
	private Boolean comValidade;
	private String busca;
	private List<Integer> localidades = new ArrayList<>();
	

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public LocalDate getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(LocalDate dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Boolean getComValidade() {
		return comValidade;
	}

	public void setComValidade(Boolean comValidade) {
		this.comValidade = comValidade;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {		
		this.busca = busca;
	}

	public List<Integer> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Integer> localidades) {
		this.localidades = localidades;
	}

	
	
	

	
	
}

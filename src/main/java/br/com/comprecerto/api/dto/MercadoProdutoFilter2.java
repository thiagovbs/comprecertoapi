package br.com.comprecerto.api.dto;

import java.time.LocalDate;

import br.com.comprecerto.api.entities.Produto;

public class MercadoProdutoFilter2 extends ProdutosAppFilter {

	private Integer idMercado;
	private Integer page;
	private Integer count;
	private LocalDate dtAlteracao;
	private LocalDate dtEntrada;
	private Boolean comValidade;
	private String busca;
	private String observacao;
	private String nome;
	private String caracteristica;
	private String marca;

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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		System.out.println(busca);
		setNome(busca);
		setCaracteristica(busca);
		setMarca(busca);
		setObservacao(busca);
		this.busca = busca;
	}
	
	

	
	
}

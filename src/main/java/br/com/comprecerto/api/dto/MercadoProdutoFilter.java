package br.com.comprecerto.api.dto;

import java.time.LocalDate;

public class MercadoProdutoFilter extends ProdutosAppFilter {

	private Integer idMercado;
	private LocalDate dtAlteracao;
	private LocalDate dtEntrada;
	private Boolean comValidade;

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
}

package br.com.comprecerto.api.dto;

import java.util.Date;

public class MercadoProdutoFilter extends ProdutosAppFilter {

	private Integer idMercado;
	private Date dtAlteracao;

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

}

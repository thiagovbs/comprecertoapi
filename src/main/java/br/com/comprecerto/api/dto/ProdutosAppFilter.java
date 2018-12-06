package br.com.comprecerto.api.dto;

public class ProdutosAppFilter {

	private Integer idEstado;
	private Integer idCidade;
	private Integer idBairro;
	private Integer idCategoria;

	public ProdutosAppFilter() {
	}

	public ProdutosAppFilter(Integer idEstado, Integer idCidade, Integer idBairro, Integer idCategoria) {
		this.idEstado = idEstado;
		this.idCidade = idCidade;
		this.idBairro = idBairro;
		this.idCategoria = idCategoria;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public Integer getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

}

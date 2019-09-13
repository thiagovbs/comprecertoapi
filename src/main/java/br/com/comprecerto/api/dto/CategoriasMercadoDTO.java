package br.com.comprecerto.api.dto;


public class CategoriasMercadoDTO {

	Integer idCategoria ;
	Integer idMercado;
	String nomeMercado;
	String nomeCategoria;
	
	
	
	public CategoriasMercadoDTO(Integer idCategoria, Integer idMercado, String nomeMercado, String nomeCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.idMercado = idMercado;
		this.nomeMercado = nomeMercado;
		this.nomeCategoria = nomeCategoria;
	}
	
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdMercado() {
		return idMercado;
	}
	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}
	public String getNomeMercado() {
		return nomeMercado;
	}
	public void setNomeMercado(String nomeMercado) {
		this.nomeMercado = nomeMercado;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	
}

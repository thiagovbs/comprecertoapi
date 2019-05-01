package br.com.comprecerto.api.dto;

public class ProdutosAppFilter extends LocalidadeFilter {

	private Integer idCategoria;
	private Integer idSubcategoria;

	public ProdutosAppFilter() {
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdSubcategoria() {
		return idSubcategoria;
	}

	public void setIdSubcategoria(Integer idSubcategoria) {
		this.idSubcategoria = idSubcategoria;
	}

}

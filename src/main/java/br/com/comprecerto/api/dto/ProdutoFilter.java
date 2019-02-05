package br.com.comprecerto.api.dto;

import java.util.Map;

import br.com.comprecerto.api.entities.Categoria;
import br.com.comprecerto.api.entities.Subcategoria;

public class ProdutoFilter {

	private Categoria categoria;
	private Subcategoria subcategoria;
	private String marca;
	private Map<String, String> unidadeMedida;

	public ProdutoFilter() {
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Map<String, String> getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(Map<String, String> unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

}

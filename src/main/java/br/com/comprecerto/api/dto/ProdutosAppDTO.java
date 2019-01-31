package br.com.comprecerto.api.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProdutosAppDTO {

	private Integer idCategoria;
	private String nomeCategoria;
	private Integer idSubcategoria;
	private String nomeSubcategoria;
	private Integer idProduto;
	private String nomeProduto;
	private String marcaProduto;
	private String unidadeMedida;
	private String caracteristicaProduto;
	private BigDecimal precoMercadoProduto;
//	private BigDecimal desconto; TODO: Aonde está esse campo??
	private Date dtValidadeMercadoProduto;
	private Integer quantidadeProduto;

	public ProdutosAppDTO() {
	}

	public ProdutosAppDTO(Integer idCategoria, String nomeCategoria, Integer idSubcategoria, String nomeSubcategoria, Integer idProduto, String nomeProduto, String marcaProduto,
			String unidadeMedida, String caracteristicaProduto, BigDecimal precoMercadoProduto, Date dtValidadeMercadoProduto, Integer quantidadeProduto) {
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
		this.idSubcategoria = idSubcategoria;
		this.nomeSubcategoria = nomeSubcategoria;
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.marcaProduto = marcaProduto;
		this.unidadeMedida = unidadeMedida;
		this.caracteristicaProduto = caracteristicaProduto;
		this.precoMercadoProduto = precoMercadoProduto;
		this.dtValidadeMercadoProduto = dtValidadeMercadoProduto;
		this.quantidadeProduto = quantidadeProduto;
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

	public String getNomeSubcategoria() {
		return nomeSubcategoria;
	}

	public void setNomeSubcategoria(String nomeSubcategoria) {
		this.nomeSubcategoria = nomeSubcategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getCaracteristicaProduto() {
		return caracteristicaProduto;
	}

	public void setCaracteristicaProduto(String caracteristicaProduto) {
		this.caracteristicaProduto = caracteristicaProduto;
	}

	public BigDecimal getPrecoMercadoProduto() {
		return precoMercadoProduto;
	}

	public void setPrecoMercadoProduto(BigDecimal precoMercadoProduto) {
		this.precoMercadoProduto = precoMercadoProduto;
	}

	public Date getDtValidadeMercadoProduto() {
		return dtValidadeMercadoProduto;
	}

	public void setDtValidadeMercadoProduto(Date dtValidadeMercadoProduto) {
		this.dtValidadeMercadoProduto = dtValidadeMercadoProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

}

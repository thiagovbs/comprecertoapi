package br.com.comprecerto.api.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.comprecerto.api.entities.MercadoServico;

public class MercadoProdutoDTO {

	private Integer idMercado;
	private String nomeFantasiaMercado;
	private String razaoSocialMercado;
	private Integer idMercadoLocalidade;
	private Integer idBairro;
	private String nomeBairro;
	private Integer idCidade;
	private String nomeCidade;
	private Integer idEstado;
	private String nomeEstado;
	private Integer idPais;
	private String nomePais;
	private String observacao;
	private Integer idCategoria;
	private String nomeCategoria;
	private Integer idSubcategoria;
	private String nomeSubcategoria;
	private Integer idProduto;
	private String nomeProduto;
	private String marcaProduto;
	private Integer quantidadeProduto;
	private String caracteristicaProduto;
	private String unidadeMedida;
	private Integer idMercadoProduto;
	private BigDecimal precoMercadoProduto;
	private Boolean fDestaqueMercadoProduto;
	private String imagemUrl;
	//	private BigDecimal desconto; TODO: Aonde está esse campo??
	private Date dtValidadeMercadoProduto;
	private List<MercadoServico> mercadoServicos;

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public String getNomeFantasiaMercado() {
		return nomeFantasiaMercado;
	}

	public void setNomeFantasiaMercado(String nomeFantasiaMercado) {
		this.nomeFantasiaMercado = nomeFantasiaMercado;
	}

	public String getRazaoSocialMercado() {
		return razaoSocialMercado;
	}

	public void setRazaoSocialMercado(String razaoSocialMercado) {
		this.razaoSocialMercado = razaoSocialMercado;
	}

	public Integer getIdMercadoLocalidade() {
		return idMercadoLocalidade;
	}

	public void setIdMercadoLocalidade(Integer idMercadoLocalidade) {
		this.idMercadoLocalidade = idMercadoLocalidade;
	}

	public Integer getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
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

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public String getCaracteristicaProduto() {
		return caracteristicaProduto;
	}

	public void setCaracteristicaProduto(String caracteristicaProduto) {
		this.caracteristicaProduto = caracteristicaProduto;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Integer getIdMercadoProduto() {
		return idMercadoProduto;
	}

	public void setIdMercadoProduto(Integer idMercadoProduto) {
		this.idMercadoProduto = idMercadoProduto;
	}

	public BigDecimal getPrecoMercadoProduto() {
		return precoMercadoProduto;
	}

	public void setPrecoMercadoProduto(BigDecimal precoMercadoProduto) {
		this.precoMercadoProduto = precoMercadoProduto;
	}

	public Boolean getfDestaqueMercadoProduto() {
		return fDestaqueMercadoProduto;
	}

	public void setfDestaqueMercadoProduto(Boolean fDestaqueMercadoProduto) {
		this.fDestaqueMercadoProduto = fDestaqueMercadoProduto;
	}

	public Date getDtValidadeMercadoProduto() {
		return dtValidadeMercadoProduto;
	}

	public void setDtValidadeMercadoProduto(Date dtValidadeMercadoProduto) {
		this.dtValidadeMercadoProduto = dtValidadeMercadoProduto;
	}

	public List<MercadoServico> getMercadoServicos() {
		return mercadoServicos;
	}

	public void setMercadoServicos(List<MercadoServico> mercadoServicos) {
		this.mercadoServicos = mercadoServicos;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
	
	
}

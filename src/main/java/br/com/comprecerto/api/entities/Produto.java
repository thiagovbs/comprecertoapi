package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(schema = "sheap", name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;

	@Type(type = "text")
	@NotBlank
	private String caracteristica;

	private Date dtAlteracao;
	private Date dtCriacao;

	@NotBlank
	@Length(max = 100)
	private String marca;

	@NotBlank
	@Length(max = 100)
	private String nome;

	@NotNull
	private Integer quantidade;

	
	private String imagemUrl;

	@OneToMany(mappedBy = "produto")
	@JsonBackReference("produto-mercadoProdutos")
	private List<MercadoProduto> mercadoProdutos;

	@ManyToOne
	@JoinColumn(name = "id_subcategoria", nullable = false)
	@NotNull
	private Subcategoria subcategoria;

	@ManyToOne
	@JoinColumn(name = "id_unidade_medida", nullable = false)
	@NotNull
	private UnidadeMedida unidadeMedida;
	
	@Column(name = "venda_por_peso", columnDefinition = "BOOLEAN")
	private Boolean vendaPorPeso;
	
	private Integer pesoMinimo;
	
	private Integer pesoMaximo;
	
	private String ean;
	
	
	@Transient
	private String imageBase64;

	public Produto() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = new Date();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = new Date();
	}

	public Integer getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Date getDtAlteracao() {
		return this.dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Date getDtCriacao() {
		return this.dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Boolean getVendaPorPeso() {
		return vendaPorPeso;
	}

	public void setCompraPorPeso(Boolean vendaPorPeso) {
		this.vendaPorPeso = vendaPorPeso;
	}

	public Integer getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(Integer pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}

	public Integer getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(Integer pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	
	public String getImageBase64() {
		return imageBase64;
	}

	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

	public List<MercadoProduto> getMercadoProdutos() {
		return this.mercadoProdutos;
	}

	public void setMercadoProdutos(List<MercadoProduto> mercadoProdutos) {
		this.mercadoProdutos = mercadoProdutos;
	}

	public MercadoProduto addMercadoProduto(MercadoProduto mercadoProduto) {
		getMercadoProdutos().add(mercadoProduto);
		mercadoProduto.setProduto(this);

		return mercadoProduto;
	}

	public MercadoProduto removeMercadoProduto(MercadoProduto mercadoProduto) {
		getMercadoProdutos().remove(mercadoProduto);
		mercadoProduto.setProduto(null);

		return mercadoProduto;
	}

	public Subcategoria getSubcategoria() {
		return this.subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", caracteristica=" + caracteristica + ", dtAlteracao=" + dtAlteracao
				+ ", dtCriacao=" + dtCriacao + ", marca=" + marca + ", nome=" + nome + ", quantidade=" + quantidade
				+ ", imagemUrl=" + imagemUrl + ", mercadoProdutos=" + mercadoProdutos + ", subcategoria=" + subcategoria
				+ ", unidadeMedida=" + unidadeMedida + ", imageBase64=" + imageBase64 + "]";
	}

	
}
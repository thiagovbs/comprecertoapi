package br.com.comprecerto.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "sheap", name = "mercado_localidade")
public class MercadoLocalidade implements Serializable {

	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMercadoLocalidade;

	private Date dtAlteracao;
	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(length = 255, nullable = false)
	@NotBlank
	private String googlemapsLinks;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_bairro", nullable = true, insertable = true, updatable = true)
	@NotNull
	private Bairro bairro;

	@ManyToOne
	@JoinColumn(name = "id_mercado", nullable = true)
	@JsonBackReference("mercadoLocalidade-mercado")
	private Mercado mercado;

	@OneToMany(mappedBy = "mercadoLocalidade", cascade =  { CascadeType.REMOVE})
	@JsonBackReference("mercadoLocalidade-mercadoProdutos")
	private List<MercadoProduto> mercadoProdutos;

	@OneToMany(mappedBy = "mercadoLocalidade", cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
	//@NotEmpty
	private List<MercadoServico> mercadoServicos;

	@Transient
	private List<Servico> servicosTemp = new ArrayList<Servico>();

	public MercadoLocalidade() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = new Date();
		fAtivo = true;
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = new Date();
	}

	public Integer getIdMercadoLocalidade() {
		return this.idMercadoLocalidade;
	}

	public void setIdMercadoLocalidade(Integer idMercadoLocalidade) {
		this.idMercadoLocalidade = idMercadoLocalidade;
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

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public String getGooglemapsLinks() {
		return googlemapsLinks;
	}

	public void setGooglemapsLinks(String googlemapsLinks) {
		this.googlemapsLinks = googlemapsLinks;
	}

	public Bairro getBairro() {
		return this.bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Mercado getMercado() {
		return this.mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public List<MercadoProduto> getMercadoProdutos() {
		return this.mercadoProdutos;
	}

	public void setMercadoProdutos(List<MercadoProduto> mercadoProdutos) {
		this.mercadoProdutos = mercadoProdutos;
	}

	public MercadoProduto addMercadoProduto(MercadoProduto mercadoProduto) {
		getMercadoProdutos().add(mercadoProduto);
		mercadoProduto.setMercadoLocalidade(this);

		return mercadoProduto;
	}

	public MercadoProduto removeMercadoProduto(MercadoProduto mercadoProduto) {
		getMercadoProdutos().remove(mercadoProduto);
		mercadoProduto.setMercadoLocalidade(null);

		return mercadoProduto;
	}

	public List<MercadoServico> getMercadoServicos() {
		return this.mercadoServicos;
	}

	public void setMercadoServicos(List<MercadoServico> mercadoServicos) {
		this.mercadoServicos = mercadoServicos;
	}

	public MercadoServico addMercadoServico(MercadoServico mercadoServico) {
		getMercadoServicos().add(mercadoServico);
		mercadoServico.setMercadoLocalidade(this);

		return mercadoServico;
	}

	public MercadoServico removeMercadoServico(MercadoServico mercadoServico) {
		getMercadoServicos().remove(mercadoServico);
		mercadoServico.setMercadoLocalidade(null);

		return mercadoServico;
	}

	public List<Servico> getServicosTemp() {
		return servicosTemp;
	}

	public void setServicosTemp(List<Servico> servicosTemp) {
		this.servicosTemp = servicosTemp;
	}

	public Servico addServicoTemp(Servico servico) {
		getServicosTemp().add(servico);

		return servico;
	}
	
	@Override
	public String toString() {
		return "MercadoLocalidade [ googlemapsLinks=" + googlemapsLinks
				+ ", bairro=" + bairro + "]";
	}

}
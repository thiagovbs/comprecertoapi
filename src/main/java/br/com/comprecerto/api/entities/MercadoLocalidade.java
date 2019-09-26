package br.com.comprecerto.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.comprecerto.api.entities.enums.Entrega;
import br.com.comprecerto.api.entities.enums.Sexo;
import br.com.comprecerto.api.services.ServicoService;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@Column(length = 255)	
	private String endereco;

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
	
	@Length(max = 14)
	private String telefone;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Entrega entrega;
	
	private Boolean frete;
	
	private BigDecimal valorMinimo;
	
	private BigDecimal valorFrete;
	
	private LocalTime horarioMaximo;
	
	
	
	@Transient
	private String imagemUrl;
	
	private LocalTime horarioMaximoEntrega;
	
	public LocalTime getHorarioMaximoEntrega() {
		return horarioMaximoEntrega;
	}

	public void setHorarioMaximoEntrega(LocalTime horarioMaximoEntrega) {
		this.horarioMaximoEntrega = horarioMaximoEntrega;
	}

	@OneToMany(mappedBy = "mercadoLocalidade")
	private List<Pedido> pedidos;

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
	
	public Boolean getfAtivo() {
		return fAtivo;
	}

	public void setfAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public Boolean getFrete() {
		return frete;
	}

	public void setFrete(Boolean frete) {
		this.frete = frete;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public LocalTime getHorarioMaximo() {
		return horarioMaximo;
	}

	public void setHorarioMaximo(LocalTime horarioMaximo) {
		this.horarioMaximo = horarioMaximo;
	}

	public String getImagemUrl() {
		if(mercado!= null) {
			this.imagemUrl=mercado.getImagemUrl();
			return this.imagemUrl;
		}
		this.imagemUrl="";
		return this.imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "MercadoLocalidade [idMercadoLocalidade=" + idMercadoLocalidade + ","+ ", mercadoServicos=" + mercadoServicos + ", servicosTemp=" + servicosTemp
				+"]";
	}
	

}
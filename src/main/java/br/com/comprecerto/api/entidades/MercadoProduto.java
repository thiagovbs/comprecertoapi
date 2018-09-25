package br.com.comprecerto.api.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "mercado_produto")
@NamedQuery(name = "MercadoProduto.findAll", query = "SELECT m FROM MercadoProduto m")
public class MercadoProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado_produto", unique = true, nullable = false)
	private Integer idMercadoProduto;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "dt_entrada")
	private LocalDateTime dtEntrada;

	@Column(name = "dt_validade")
	private LocalDateTime dtValidade;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Column(name = "f_destaque")
	private Boolean fDestaque;

	@Column(name = "f_super_destaque")
	private Boolean fSuperDestaque;

	@Lob
	private String observacao;

	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(name = "id_mercado_localidade")
	private MercadoLocalidade mercadoLocalidade;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	@OneToMany(mappedBy = "mercadoProduto")
	private List<UsuarioLista> usuarioListas;

	public MercadoProduto() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdMercadoProduto() {
		return this.idMercadoProduto;
	}

	public void setIdMercadoProduto(Integer idMercadoProduto) {
		this.idMercadoProduto = idMercadoProduto;
	}

	public LocalDateTime getDtAlteracao() {
		return this.dtAlteracao;
	}

	public void setDtAlteracao(LocalDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public LocalDateTime getDtCriacao() {
		return this.dtCriacao;
	}

	public void setDtCriacao(LocalDateTime dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public LocalDateTime getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(LocalDateTime dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDateTime getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(LocalDateTime dtValidade) {
		this.dtValidade = dtValidade;
	}

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public Boolean getFDestaque() {
		return this.fDestaque;
	}

	public void setFDestaque(Boolean fDestaque) {
		this.fDestaque = fDestaque;
	}

	public Boolean getFSuperDestaque() {
		return this.fSuperDestaque;
	}

	public void setFSuperDestaque(Boolean fSuperDestaque) {
		this.fSuperDestaque = fSuperDestaque;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public MercadoLocalidade getMercadoLocalidade() {
		return this.mercadoLocalidade;
	}

	public void setMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		this.mercadoLocalidade = mercadoLocalidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<UsuarioLista> getUsuarioListas() {
		return this.usuarioListas;
	}

	public void setUsuarioListas(List<UsuarioLista> usuarioListas) {
		this.usuarioListas = usuarioListas;
	}

	public UsuarioLista addUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().add(usuarioLista);
		usuarioLista.setMercadoProduto(this);

		return usuarioLista;
	}

	public UsuarioLista removeUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().remove(usuarioLista);
		usuarioLista.setMercadoProduto(null);

		return usuarioLista;
	}

}
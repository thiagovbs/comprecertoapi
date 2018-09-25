package br.com.comprecerto.api.entidades;

import java.io.Serializable;
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
@Table(name = "mercado_push")
@NamedQuery(name = "MercadoPush.findAll", query = "SELECT m FROM MercadoPush m")
public class MercadoPush implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado_push", unique = true, nullable = false)
	private Integer idMercadoPush;

	@Column(length = 255)
	private String descricao;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Lob
	private byte[] imagem;

	@Lob
	@Column(name = "motivo_negativa")
	private String motivoNegativa;

	@Column(name = "tipo_push")
	private short tipoPush;

	@ManyToOne
	@JoinColumn(name = "id_mercado")
	private Mercado mercado;

	@OneToMany(mappedBy = "mercadoPush")
	private List<UsuarioMercadoPush> usuarioMercadoPushs;

	public MercadoPush() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdMercadoPush() {
		return this.idMercadoPush;
	}

	public void setIdMercadoPush(Integer idMercadoPush) {
		this.idMercadoPush = idMercadoPush;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public byte[] getImagem() {
		return this.imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getMotivoNegativa() {
		return this.motivoNegativa;
	}

	public void setMotivoNegativa(String motivoNegativa) {
		this.motivoNegativa = motivoNegativa;
	}

	public short getTipoPush() {
		return this.tipoPush;
	}

	public void setTipoPush(short tipoPush) {
		this.tipoPush = tipoPush;
	}

	public Mercado getMercado() {
		return this.mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public List<UsuarioMercadoPush> getUsuarioMercadoPushs() {
		return this.usuarioMercadoPushs;
	}

	public void setUsuarioMercadoPushs(List<UsuarioMercadoPush> usuarioMercadoPushs) {
		this.usuarioMercadoPushs = usuarioMercadoPushs;
	}

	public UsuarioMercadoPush addUsuarioMercadoPush(UsuarioMercadoPush usuarioMercadoPush) {
		getUsuarioMercadoPushs().add(usuarioMercadoPush);
		usuarioMercadoPush.setMercadoPush(this);

		return usuarioMercadoPush;
	}

	public UsuarioMercadoPush removeUsuarioMercadoPush(UsuarioMercadoPush usuarioMercadoPush) {
		getUsuarioMercadoPushs().remove(usuarioMercadoPush);
		usuarioMercadoPush.setMercadoPush(null);

		return usuarioMercadoPush;
	}

}
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema = "sheap", name = "mercado_push")
public class MercadoPush implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado_push", unique = true, nullable = false)
	private Integer idMercadoPush;

	@Column(length = 255)
	private String descricao;

	@Column(name = "dt_alteracao")
	private Date dtAlteracao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Lob
	private byte[] imagem;

	@Type(type="text")
	@Column(name = "motivo_negativa")
	private String motivoNegativa;

	@Column(name = "tipo_push")
	private short tipoPush;

	@Column(name = "data_hora_exibicao")
	private Date dataHoraExibicao;

	@Column(name = "promocao", columnDefinition = "BOOLEAN")
	private Boolean promocao;

	@Column(name = "data_validade")
	private Date dataValidade;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = true)
	@JsonBackReference(value = "categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_mercado", nullable = true)
	@JsonBackReference(value = "mercado")
	private Mercado mercado;

	@OneToMany(mappedBy = "mercadoPush")
	private List<UsuarioMercadoPush> usuarioMercadoPushs;

	public MercadoPush() {
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

	public Date getDataHoraExibicao() {
		return dataHoraExibicao;
	}

	public void setDataHoraExibicao(Date dataHoraExibicao) {
		this.dataHoraExibicao = dataHoraExibicao;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
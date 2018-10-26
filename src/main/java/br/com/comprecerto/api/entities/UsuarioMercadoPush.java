package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_mercado_push")
public class UsuarioMercadoPush implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_mercado_push", unique = true, nullable = false)
	private Integer idUsuarioMercadoPush;

	@Column(name = "dt_ativacao")
	private Date dtAtivacao;

	@ManyToOne
	@JoinColumn(name = "id_mercado_push", nullable = true)
	@NotNull
	private MercadoPush mercadoPush;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = true)
	@NotNull
	private Usuario usuario;

	public UsuarioMercadoPush() {
	}

	public Integer getIdUsuarioMercadoPush() {
		return this.idUsuarioMercadoPush;
	}

	public void setIdUsuarioMercadoPush(Integer idUsuarioMercadoPush) {
		this.idUsuarioMercadoPush = idUsuarioMercadoPush;
	}

	public Date getDtAtivacao() {
		return this.dtAtivacao;
	}

	public void setDtAtivacao(Date dtAtivacao) {
		this.dtAtivacao = dtAtivacao;
	}

	public MercadoPush getMercadoPush() {
		return this.mercadoPush;
	}

	public void setMercadoPush(MercadoPush mercadoPush) {
		this.mercadoPush = mercadoPush;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
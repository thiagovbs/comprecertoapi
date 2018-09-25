package br.com.comprecerto.api.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_mercado_push")
@NamedQuery(name = "UsuarioMercadoPush.findAll", query = "SELECT u FROM UsuarioMercadoPush u")
public class UsuarioMercadoPush implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_mercado_push", unique = true, nullable = false)
	private Integer idUsuarioMercadoPush;

	@Column(name = "dt_ativacao")
	private LocalDateTime dtAtivacao;

	@ManyToOne
	@JoinColumn(name = "id_mercado_push")
	private MercadoPush mercadoPush;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public UsuarioMercadoPush() {
	}

	public Integer getIdUsuarioMercadoPush() {
		return this.idUsuarioMercadoPush;
	}

	public void setIdUsuarioMercadoPush(Integer idUsuarioMercadoPush) {
		this.idUsuarioMercadoPush = idUsuarioMercadoPush;
	}

	public LocalDateTime getDtAtivacao() {
		return this.dtAtivacao;
	}

	public void setDtAtivacao(LocalDateTime dtAtivacao) {
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
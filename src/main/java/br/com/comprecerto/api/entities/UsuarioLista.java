package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "usuario_lista")
public class UsuarioLista implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario_lista", unique = true, nullable = false)
	private Integer idUsuarioLista;

	@Column(length = 50)
	private String descricao;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@ManyToOne
	@JoinColumn(name = "id_mercado_produto", nullable = true)
	@NotNull
	private MercadoProduto mercadoProduto;

	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = true)
	@NotNull
	private Usuario usuario;

	public UsuarioLista() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdUsuarioLista() {
		return this.idUsuarioLista;
	}

	public void setIdUsuarioLista(Integer idUsuarioLista) {
		this.idUsuarioLista = idUsuarioLista;
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

	public MercadoProduto getMercadoProduto() {
		return this.mercadoProduto;
	}

	public void setMercadoProduto(MercadoProduto mercadoProduto) {
		this.mercadoProduto = mercadoProduto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
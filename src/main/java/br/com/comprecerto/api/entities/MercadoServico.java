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
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "mercado_servico")
@NamedQuery(name = "MercadoServico.findAll", query = "SELECT m FROM MercadoServico m")
public class MercadoServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado_servico", unique = true, nullable = false)
	private Integer idMercadoServico;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "dt_fim_servico")
	private LocalDateTime dtFimServico;

	@Column(name = "dt_inicio_servico")
	private LocalDateTime dtInicioServico;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@ManyToOne
	@JoinColumn(name = "id_mercado")
	private Mercado mercado;

	@ManyToOne
	@JoinColumn(name = "id_pacote_servico")
	private PacoteServico pacoteServico;

	public MercadoServico() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdMercadoServico() {
		return this.idMercadoServico;
	}

	public void setIdMercadoServico(Integer idMercadoServico) {
		this.idMercadoServico = idMercadoServico;
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

	public LocalDateTime getDtFimServico() {
		return this.dtFimServico;
	}

	public void setDtFimServico(LocalDateTime dtFimServico) {
		this.dtFimServico = dtFimServico;
	}

	public LocalDateTime getDtInicioServico() {
		return this.dtInicioServico;
	}

	public void setDtInicioServico(LocalDateTime dtInicioServico) {
		this.dtInicioServico = dtInicioServico;
	}

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public Mercado getMercado() {
		return this.mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public PacoteServico getPacoteServico() {
		return this.pacoteServico;
	}

	public void setPacoteServico(PacoteServico pacoteServico) {
		this.pacoteServico = pacoteServico;
	}

}
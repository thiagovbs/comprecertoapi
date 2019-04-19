package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@Table(schema = "sheap", name = "mercado_servico")
public class MercadoServico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado_servico", unique = true, nullable = false)
	private Integer idMercadoServico;

	@Column(name = "dt_alteracao")
	private Date dtAlteracao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(name = "dt_fim_servico")
	private Date dtFimServico;

	@Column(name = "dt_inicio_servico")
	private Date dtInicioServico;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@NotNull
	private BigDecimal saldo;

	@ManyToOne
	@JoinColumn(name = "id_mercado_localidade", nullable = true)
	private MercadoLocalidade mercadoLocalidade;

	@ManyToOne
	@JoinColumn(name = "id_pacote_servico", nullable = true)
	@NotNull
	private PacoteServico pacoteServico;

	public MercadoServico() {
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

	public Integer getIdMercadoServico() {
		return this.idMercadoServico;
	}

	public void setIdMercadoServico(Integer idMercadoServico) {
		this.idMercadoServico = idMercadoServico;
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

	public Date getDtFimServico() {
		return this.dtFimServico;
	}

	public void setDtFimServico(Date dtFimServico) {
		this.dtFimServico = dtFimServico;
	}

	public Date getDtInicioServico() {
		return this.dtInicioServico;
	}

	public void setDtInicioServico(Date dtInicioServico) {
		this.dtInicioServico = dtInicioServico;
	}

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public MercadoLocalidade getMercadoLocalidade() {
		return this.mercadoLocalidade;
	}

	public void setMercadoLocalidade(MercadoLocalidade mercado) {
		this.mercadoLocalidade = mercado;
	}

	public PacoteServico getPacoteServico() {
		return this.pacoteServico;
	}

	public void setPacoteServico(PacoteServico pacoteServico) {
		this.pacoteServico = pacoteServico;
	}

}
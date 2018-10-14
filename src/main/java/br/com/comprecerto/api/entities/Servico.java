package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico", unique = true, nullable = false)
	private Integer idServico;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(length = 100)
	private String nome;

	@Column(length = 60)
	private String tipo;

	@OneToMany(mappedBy = "servico")
	private List<PacoteServico> pacoteServicos;

	public Servico() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
		fAtivo = true;
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdServico() {
		return this.idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<PacoteServico> getPacoteServicos() {
		return this.pacoteServicos;
	}

	public void setPacoteServicos(List<PacoteServico> pacoteServicos) {
		this.pacoteServicos = pacoteServicos;
	}

	public PacoteServico addPacoteServico(PacoteServico pacoteServico) {
		getPacoteServicos().add(pacoteServico);
		pacoteServico.setServico(this);

		return pacoteServico;
	}

	public PacoteServico removePacoteServico(PacoteServico pacoteServico) {
		getPacoteServicos().remove(pacoteServico);
		pacoteServico.setServico(null);

		return pacoteServico;
	}

}
package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema = "sheap", name = "servico")
public class Servico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico", unique = true, nullable = false)
	private Integer idServico;

	@Column(name = "dt_alteracao")
	private Date dtAlteracao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(length = 100)
	private String nome;

	@OneToMany(mappedBy = "servico")
	@JsonManagedReference(value = "servico_pacoteServico")
	private List<PacoteServico> pacoteServicos;

	@Transient
	private PacoteServico pacoteSelecionado;

	public Servico() {
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

	public Integer getIdServico() {
		return this.idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
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

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public String getTipo() {
//		return this.tipo;
//	}
//
//	public void setTipo(String tipo) {
//		this.tipo = tipo;
//	}

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

	public PacoteServico getPacoteSelecionado() {
		return pacoteSelecionado;
	}

	public void setPacoteSelecionado(PacoteServico pacoteSelecionado) {
		this.pacoteSelecionado = pacoteSelecionado;
	}

	@Override
	public String toString() {
		return "Servico [idServico=" + idServico + ", dtAlteracao=" + dtAlteracao + ", dtCriacao=" + dtCriacao + ", fAtivo=" + fAtivo + ", nome=" + nome + ", pacoteServicos="
				+ pacoteServicos + ", pacoteSelecionado=" + pacoteSelecionado + "]";
	}

}
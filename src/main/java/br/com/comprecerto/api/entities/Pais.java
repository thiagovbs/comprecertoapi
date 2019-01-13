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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPais;

	private Date dtAlteracao;

	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@NotBlank
	@Length(max = 150)
	private String nome;

	@NotBlank
	@Length(max = 3)
	private String sigla;

	@OneToMany(mappedBy = "pais")
	@JsonBackReference(value = "estado")
	private List<Estado> estados;

	public Pais() {
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

	public Integer getIdPais() {
		return this.idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
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

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado addEstado(Estado estado) {
		getEstados().add(estado);
		estado.setPais(this);

		return estado;
	}

	public Estado removeEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setPais(null);

		return estado;
	}

}
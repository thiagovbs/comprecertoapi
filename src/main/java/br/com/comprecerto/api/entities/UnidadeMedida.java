package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "unidade_medida")
public class UnidadeMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUnidade;

	private Date dtAlteracao;

	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@NotBlank
	@Length(max = 45)
	private String nome;

	@NotBlank
	@Length(max = 5)
	private String sigla;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "categoria_unidade_medida", joinColumns = @JoinColumn(name = "id_unidade"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))
	@JsonIgnore
	private List<Categoria> categorias;

	public UnidadeMedida() {
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

	public Integer getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
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
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
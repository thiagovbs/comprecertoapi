package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "cidade")
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade", unique = true, nullable = false)
	private Integer idCidade;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Column(length = 100, unique = true)
	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "cidade")
	private List<Bairro> bairros;

	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false)
	private Estado estado;

	public Cidade() {
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

	public Integer getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
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

	public List<Bairro> getBairros() {
		return this.bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro addBairro(Bairro bairro) {
		getBairros().add(bairro);
		bairro.setCidade(this);

		return bairro;
	}

	public Bairro removeBairro(Bairro bairro) {
		getBairros().remove(bairro);
		bairro.setCidade(null);

		return bairro;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_medida")
@NamedQuery(name = "UnidadeMedida.findAll", query = "SELECT u FROM UnidadeMedida u")
public class UnidadeMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidade", unique = true, nullable = false)
	private Integer idUnidade;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Column(name = "id_categoria_unidade_medida")
	private Integer idCategoriaUnidadeMedida;

	@Column(length = 45)
	private String nome;

	@OneToMany(mappedBy = "unidadeMedida")
	private List<CategoriaUnidadeMedida> categoriaUnidadeMedidas;

	public UnidadeMedida() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Integer idUnidade) {
		this.idUnidade = idUnidade;
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

	public Integer getIdCategoriaUnidadeMedida() {
		return this.idCategoriaUnidadeMedida;
	}

	public void setIdCategoriaUnidadeMedida(Integer idCategoriaUnidadeMedida) {
		this.idCategoriaUnidadeMedida = idCategoriaUnidadeMedida;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CategoriaUnidadeMedida> getCategoriaUnidadeMedidas() {
		return this.categoriaUnidadeMedidas;
	}

	public void setCategoriaUnidadeMedidas(List<CategoriaUnidadeMedida> categoriaUnidadeMedidas) {
		this.categoriaUnidadeMedidas = categoriaUnidadeMedidas;
	}

	public CategoriaUnidadeMedida addCategoriaUnidadeMedida(CategoriaUnidadeMedida categoriaUnidadeMedida) {
		getCategoriaUnidadeMedidas().add(categoriaUnidadeMedida);
		categoriaUnidadeMedida.setUnidadeMedida(this);

		return categoriaUnidadeMedida;
	}

	public CategoriaUnidadeMedida removeCategoriaUnidadeMedida(CategoriaUnidadeMedida categoriaUnidadeMedida) {
		getCategoriaUnidadeMedidas().remove(categoriaUnidadeMedida);
		categoriaUnidadeMedida.setUnidadeMedida(null);

		return categoriaUnidadeMedida;
	}

}
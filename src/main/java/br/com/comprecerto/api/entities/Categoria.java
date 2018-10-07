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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "categoria")
@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria", unique = true, nullable = false)
	private Integer idCategoria;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Column(length = 100, unique = true)
	@NotBlank
	private String nome;

	@OneToMany(mappedBy = "categoria")
	@NotEmpty
	private List<CategoriaUnidadeMedida> categoriaUnidadeMedidas;

	@OneToMany(mappedBy = "categoria")
	private List<Subcategoria> subcategorias;

	public Categoria() {
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

	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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

	public List<CategoriaUnidadeMedida> getCategoriaUnidadeMedidas() {
		return this.categoriaUnidadeMedidas;
	}

	public void setCategoriaUnidadeMedidas(List<CategoriaUnidadeMedida> categoriaUnidadeMedidas) {
		this.categoriaUnidadeMedidas = categoriaUnidadeMedidas;
	}

	public CategoriaUnidadeMedida addCategoriaUnidadeMedida(CategoriaUnidadeMedida categoriaUnidadeMedida) {
		getCategoriaUnidadeMedidas().add(categoriaUnidadeMedida);
		categoriaUnidadeMedida.setCategoria(this);

		return categoriaUnidadeMedida;
	}

	public CategoriaUnidadeMedida removeCategoriaUnidadeMedida(CategoriaUnidadeMedida categoriaUnidadeMedida) {
		getCategoriaUnidadeMedidas().remove(categoriaUnidadeMedida);
		categoriaUnidadeMedida.setCategoria(null);

		return categoriaUnidadeMedida;
	}

	public List<Subcategoria> getSubcategorias() {
		return this.subcategorias;
	}

	public void setSubcategorias(List<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public Subcategoria addSubcategoria(Subcategoria subcategoria) {
		getSubcategorias().add(subcategoria);
		subcategoria.setCategoria(this);

		return subcategoria;
	}

	public Subcategoria removeSubcategoria(Subcategoria subcategoria) {
		getSubcategorias().remove(subcategoria);
		subcategoria.setCategoria(null);

		return subcategoria;
	}

}
package br.com.comprecerto.api.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "categoria_unidade_medida")
@NamedQuery(name = "CategoriaUnidadeMedida.findAll", query = "SELECT c FROM CategoriaUnidadeMedida c")
public class CategoriaUnidadeMedida implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria_unidade_medida", unique = true, nullable = false)
	private long idCategoriaUnidadeMedida;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_unidade")
	private UnidadeMedida unidadeMedida;

	public CategoriaUnidadeMedida() {
	}

	public long getIdCategoriaUnidadeMedida() {
		return this.idCategoriaUnidadeMedida;
	}

	public void setIdCategoriaUnidadeMedida(long idCategoriaUnidadeMedida) {
		this.idCategoriaUnidadeMedida = idCategoriaUnidadeMedida;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public UnidadeMedida getUnidadeMedida() {
		return this.unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

}
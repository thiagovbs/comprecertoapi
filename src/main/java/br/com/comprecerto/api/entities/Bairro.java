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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "bairro")
public class Bairro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bairro", unique = true, nullable = false)
	private Integer idBairro;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao", nullable = false)
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(length = 100, unique = true, nullable = false)
	@NotBlank
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_cidade", nullable = false)
	@NotNull
	private Cidade cidade;

	@OneToMany(mappedBy = "bairro")
	private List<MercadoLocalidade> mercadoLocalidades;

	public Bairro() {
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

	public Integer getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
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

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<MercadoLocalidade> getMercadoLocalidades() {
		return this.mercadoLocalidades;
	}

	public void setMercadoLocalidades(List<MercadoLocalidade> mercadoLocalidades) {
		this.mercadoLocalidades = mercadoLocalidades;
	}

	public MercadoLocalidade addMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		getMercadoLocalidades().add(mercadoLocalidade);
		mercadoLocalidade.setBairro(this);

		return mercadoLocalidade;
	}

	public MercadoLocalidade removeMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		getMercadoLocalidades().remove(mercadoLocalidade);
		mercadoLocalidade.setBairro(null);

		return mercadoLocalidade;
	}

}
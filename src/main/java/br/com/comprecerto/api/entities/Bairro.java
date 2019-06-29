package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(schema = "sheap", name = "bairro")
public class Bairro implements Serializable {

	@Override
	public String toString() {
		return "Bairro [idBairro=" + idBairro + ", dtAlteracao=" + dtAlteracao + ", dtCriacao=" + dtCriacao
				+ ", fAtivo=" + fAtivo + ", nome=" + nome + ", cidade=" + cidade + ", mercadoLocalidades="
				+ mercadoLocalidades + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBairro;

	private Date dtAlteracao;

	private Date dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@NotBlank
	@Length(max = 100)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	@NotNull
	private Cidade cidade;

	@OneToMany(mappedBy = "bairro")
	@JsonBackReference(value = "mercadoLocalidade")
	private List<MercadoLocalidade> mercadoLocalidades;

	public Bairro() {
	}

	public Bairro(Integer idBairro) {
		this.idBairro = idBairro;
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

	public Integer getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
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
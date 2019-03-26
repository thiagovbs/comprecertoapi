package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(schema = "sheap", name = "mercado")
public class Mercado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMercado;

	@NotBlank
	@Length(max = 18)
	private String cnpj;

	private Date dtAlteracao;

	private Date dtCriacao;

	@NotBlank
	@Length(max = 100)
	private String email;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(name = "f_destaque", columnDefinition = "BOOLEAN")
	private Boolean fDestaque;

	@Column(name = "f_super_destaque", columnDefinition = "BOOLEAN")
	private Boolean fSuperDestaque;

	@Lob
	private byte[] logo;

	@NotBlank
	@Length(max = 150)
	private String nomeFantasia;

	@NotBlank
	@Length(max = 150)
	private String razaoSocial;

	@Type(type="text")
	private String slogan;

	@NotBlank
	@Length(max = 13)
	private String telefone;

	@NotBlank
	private String imagemUrl;

	@OneToMany(mappedBy = "mercado", cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = true)
	@NotEmpty
	@JsonManagedReference(value = "mercado_mercadoLocalidade")
	private List<MercadoLocalidade> mercadoLocalidades;

	@OneToMany(mappedBy = "mercado")
	private List<MercadoPush> mercadoPushs;

	public Mercado() {
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

	public Integer getIdMercado() {
		return this.idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getFAtivo() {
		return this.fAtivo;
	}

	public void setFAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	public Boolean getFDestaque() {
		return this.fDestaque;
	}

	public void setFDestaque(Boolean fDestaque) {
		this.fDestaque = fDestaque;
	}

	public Boolean getFSuperDestaque() {
		return this.fSuperDestaque;
	}

	public void setFSuperDestaque(Boolean fSuperDestaque) {
		this.fSuperDestaque = fSuperDestaque;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<MercadoLocalidade> getMercadoLocalidades() {
		return this.mercadoLocalidades;
	}

	public void setMercadoLocalidades(List<MercadoLocalidade> mercadoLocalidades) {
		this.mercadoLocalidades = mercadoLocalidades;
	}

	public MercadoLocalidade addMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		getMercadoLocalidades().add(mercadoLocalidade);
		mercadoLocalidade.setMercado(this);

		return mercadoLocalidade;
	}

	public MercadoLocalidade removeMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		getMercadoLocalidades().remove(mercadoLocalidade);
		mercadoLocalidade.setMercado(null);

		return mercadoLocalidade;
	}

	public List<MercadoPush> getMercadoPushs() {
		return this.mercadoPushs;
	}

	public void setMercadoPushs(List<MercadoPush> mercadoPushs) {
		this.mercadoPushs = mercadoPushs;
	}

	public MercadoPush addMercadoPush(MercadoPush mercadoPush) {
		getMercadoPushs().add(mercadoPush);
		mercadoPush.setMercado(this);

		return mercadoPush;
	}

	public MercadoPush removeMercadoPush(MercadoPush mercadoPush) {
		getMercadoPushs().remove(mercadoPush);
		mercadoPush.setMercado(null);

		return mercadoPush;
	}

}
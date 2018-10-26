package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "mercado")
public class Mercado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mercado", unique = true, nullable = false)
	private Integer idMercado;

	@Column(unique = true, nullable = false)
	@NotBlank
	private Integer cnpj;

	@Column(name = "dt_alteracao")
	private Date dtAlteracao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(length = 100, unique = true, nullable = false)
	@NotBlank
	private String email;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(name = "f_destaque", columnDefinition = "BOOLEAN")
	private Boolean fDestaque;

	@Column(name = "f_super_destaque", columnDefinition = "BOOLEAN")
	private Boolean fSuperDestaque;

	@Lob
	private byte[] logo;

	@Column(name = "nome_fantasia", length = 150, nullable = false)
	@NotBlank
	private String nomeFantasia;

	@Column(name = "razao_social", length = 150, nullable = false)
	@NotBlank
	private String razaoSocial;

	@Lob
	private String slogan;

	@Column(length = 255, nullable = false)
	@NotBlank
	private String telefones;

	@OneToMany(mappedBy = "mercado")
	private List<MercadoLocalidade> mercadoLocalidades;

	@OneToMany(mappedBy = "mercado")
	private List<MercadoPush> mercadoPushs;

	@OneToMany(mappedBy = "mercado")
	private List<MercadoServico> mercadoServicos;

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

	public Integer getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(Integer cnpj) {
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

	public String getTelefones() {
		return this.telefones;
	}

	public void setTelefones(String telefones) {
		this.telefones = telefones;
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

	public List<MercadoServico> getMercadoServicos() {
		return this.mercadoServicos;
	}

	public void setMercadoServicos(List<MercadoServico> mercadoServicos) {
		this.mercadoServicos = mercadoServicos;
	}

	public MercadoServico addMercadoServico(MercadoServico mercadoServico) {
		getMercadoServicos().add(mercadoServico);
		mercadoServico.setMercado(this);

		return mercadoServico;
	}

	public MercadoServico removeMercadoServico(MercadoServico mercadoServico) {
		getMercadoServicos().remove(mercadoServico);
		mercadoServico.setMercado(null);

		return mercadoServico;
	}

}
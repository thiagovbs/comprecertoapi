package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.comprecerto.api.entities.enums.Sexo;

@Entity
@Table(schema = "sheap", name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Integer idUsuario;

	@Column(name = "dt_alteracao")
	private Date dtAlteracao;

	@Column(name = "dt_criacao")
	private Date dtCriacao;

	@Column(name = "dt_nascimento")
	private Date dtNascimento;

	@Column(length = 150, unique = true, nullable = false)
	@NotBlank
	private String email;

	@Column(length = 18, unique = true, nullable = false)
	@NotBlank
	private String login;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(length = 100, unique = true, nullable = false)
	@NotBlank
	private String nome;

	@Column(length = 100, nullable = false)
	@NotBlank
	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	@NotNull
	private Sexo sexo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(schema = "sheap", name = "usuario_permissao", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_permissao"))
	@NotEmpty
	private Set<Permissao> permissoes;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<UsuarioLista> usuarioListas;

	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<UsuarioMercadoPush> usuarioMercadoPushs;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mercado")
	private Mercado mercado;

	public Usuario() {
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

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public List<UsuarioLista> getUsuarioListas() {
		return this.usuarioListas;
	}

	public void setUsuarioListas(List<UsuarioLista> usuarioListas) {
		this.usuarioListas = usuarioListas;
	}

	public UsuarioLista addUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().add(usuarioLista);
		usuarioLista.setUsuario(this);

		return usuarioLista;
	}

	public UsuarioLista removeUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().remove(usuarioLista);
		usuarioLista.setUsuario(null);

		return usuarioLista;
	}

	public List<UsuarioMercadoPush> getUsuarioMercadoPushs() {
		return this.usuarioMercadoPushs;
	}

	public void setUsuarioMercadoPushs(List<UsuarioMercadoPush> usuarioMercadoPushs) {
		this.usuarioMercadoPushs = usuarioMercadoPushs;
	}

	public UsuarioMercadoPush addUsuarioMercadoPush(UsuarioMercadoPush usuarioMercadoPush) {
		getUsuarioMercadoPushs().add(usuarioMercadoPush);
		usuarioMercadoPush.setUsuario(this);

		return usuarioMercadoPush;
	}

	public UsuarioMercadoPush removeUsuarioMercadoPush(UsuarioMercadoPush usuarioMercadoPush) {
		getUsuarioMercadoPushs().remove(usuarioMercadoPush);
		usuarioMercadoPush.setUsuario(null);

		return usuarioMercadoPush;
	}

	public Mercado getMercado() {
		return mercado;
	}

	public void setMercado(Mercado mercado) {
		this.mercado = mercado;
	}

	public boolean isAdmin() {
		return this.getPermissoes().stream().filter(permissao -> permissao.getDescricao().equals("MERCADO_ADMIN")).count() > 0;
	}

}
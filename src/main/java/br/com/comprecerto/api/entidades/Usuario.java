package br.com.comprecerto.api.entidades;

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
@Table(name = "usuario")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Integer idUsuario;

	@Column(name = "dt_alteracao")
	private LocalDateTime dtAlteracao;

	@Column(name = "dt_criacao")
	private LocalDateTime dtCriacao;

	@Column(name = "dt_nascimento")
	private LocalDateTime dtNascimento;

	@Column(length = 150)
	private String email;

	@Column(name = "f_ativo")
	private Boolean fAtivo;

	@Column(length = 100)
	private String nome;

	@Column(length = 100)
	private String senha;

	@Column(length = 1)
	private Sexo sexo;

	@OneToMany(mappedBy = "usuario")
	private List<UsuarioLista> usuarioListas;

	@OneToMany(mappedBy = "usuario")
	private List<UsuarioMercadoPush> usuarioMercadoPushs;

	public Usuario() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = LocalDateTime.now();
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = LocalDateTime.now();
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public LocalDateTime getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(LocalDateTime dtNascimento) {
		this.dtNascimento = dtNascimento;
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

}
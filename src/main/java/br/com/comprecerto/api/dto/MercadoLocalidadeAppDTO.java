package br.com.comprecerto.api.dto;

import java.io.Serializable;
import java.util.List;

import br.com.comprecerto.api.entities.MercadoLocalidade;
import br.com.comprecerto.api.entities.MercadoServico;

public class MercadoLocalidadeAppDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idMercado;
	private String imagemURL;
	private String nomeFantasia;
	private String slogan;
	private String telefone;
	private String endereco;
	private String googlemapsLinks;
	private Integer idMercadoLocalidade;
	private List<MercadoServico> mercadoServicos;

	public MercadoLocalidadeAppDTO() {

	}

	public MercadoLocalidadeAppDTO(MercadoLocalidade ml) {
		super();
		this.idMercado = ml.getMercado().getIdMercado();
		this.imagemURL = ml.getMercado().getImagemUrl();
		this.googlemapsLinks = ml.getGooglemapsLinks();
		this.nomeFantasia = ml.getMercado().getNomeFantasia();
		this.slogan = ml.getMercado().getSlogan();
		this.telefone = ml.getTelefone();
		this.endereco = ml.getEndereco();
		this.idMercadoLocalidade = ml.getIdMercadoLocalidade();
		this.mercadoServicos = ml.getMercadoServicos();
		
	}

	public Integer getIdMercado() {
		return idMercado;
	}

	public void setIdMercado(Integer idMercado) {
		this.idMercado = idMercado;
	}

	public String getImagemURL() {
		return imagemURL;
	}

	public void setImagemURL(String imagemURL) {
		this.imagemURL = imagemURL;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSlogan() {
		return slogan;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getIdMercadoLocalidade() {
		return idMercadoLocalidade;
	}

	public void setIdMercadoLocalidade(Integer idMercadoLocalidade) {
		this.idMercadoLocalidade = idMercadoLocalidade;
	}

	public List<MercadoServico> getMercadoServicos() {
		return mercadoServicos;
	}

	public void setMercadoServicos(List<MercadoServico> mercadoServicos) {
		this.mercadoServicos = mercadoServicos;
	}

	public String getGooglemapsLinks() {
		return googlemapsLinks;
	}

	public void setGooglemapsLinks(String googlemapsLinks) {
		this.googlemapsLinks = googlemapsLinks;
	}
	
	

}

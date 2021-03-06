package br.com.comprecerto.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(schema = "sheap", name = "mercado_produto")
public class MercadoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMercadoProduto;

	private LocalDateTime dtAlteracao;
	private LocalDateTime dtCriacao;

	private LocalDate dtEntrada;
	private LocalDate dtValidade;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@Column(name = "f_destaque", columnDefinition = "BOOLEAN")
	private Boolean fDestaque;

	@Column(name = "f_super_destaque", columnDefinition = "BOOLEAN")
	private Boolean fSuperDestaque;

	@JsonDeserialize(using = CustomDeserializer.class)
	@Type(type = "text")	
	private String observacao;

	@NotNull
	private BigDecimal preco;

	@ManyToOne
	@JoinColumn(name = "id_mercado_localidade")
	@NotNull
	@JsonBackReference("mercadoProduto-mercadoLocalidade")
	private MercadoLocalidade mercadoLocalidade;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	@NotNull
	private Produto produto;

	@OneToMany(mappedBy = "mercadoProduto")
	@JsonBackReference("mercadoProduto-usuarioListas")
	private List<UsuarioLista> usuarioListas;

	public MercadoProduto() {
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

	public Integer getIdMercadoProduto() {
		return this.idMercadoProduto;
	}

	public void setIdMercadoProduto(Integer idMercadoProduto) {
		this.idMercadoProduto = idMercadoProduto;
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

	public LocalDate getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(LocalDate dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public LocalDate getDtValidade() {
		return this.dtValidade;
	}

	public void setDtValidade(LocalDate dtValidade) {
		this.dtValidade = dtValidade;
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

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public MercadoLocalidade getMercadoLocalidade() {
		return this.mercadoLocalidade;
	}

	public void setMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		this.mercadoLocalidade = mercadoLocalidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<UsuarioLista> getUsuarioListas() {
		return this.usuarioListas;
	}

	public void setUsuarioListas(List<UsuarioLista> usuarioListas) {
		this.usuarioListas = usuarioListas;
	}

	public UsuarioLista addUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().add(usuarioLista);
		usuarioLista.setMercadoProduto(this);

		return usuarioLista;
	}

	public UsuarioLista removeUsuarioLista(UsuarioLista usuarioLista) {
		getUsuarioListas().remove(usuarioLista);
		usuarioLista.setMercadoProduto(null);

		return usuarioLista;
	}
	
	@Override
	public String toString() {
		return "MercadoProduto [idMercadoProduto=" + idMercadoProduto +  "]";
	}
}



class CustomDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.readValueAsTree();
        if (node.asText().isEmpty()) {
            return null;
        }
        return node.toString();
    }

}
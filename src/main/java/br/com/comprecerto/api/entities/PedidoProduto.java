package br.com.comprecerto.api.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "sheap", name = "pedido_produto")
public class PedidoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedidoProduto;

	private LocalDateTime dtAlteracao;
	private LocalDateTime dtCriacao;

	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;	
	
	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private Integer quantidade;
	
	@ManyToOne
    @JoinColumn(name="id_produto", nullable=false)
	private Produto produto;
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne
	@JoinColumn(name="id_pedido")
	@JsonBackReference("pedidoprodutos-pedido")
	private Pedido pedido;


	public PedidoProduto() {
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

	public Integer getIdPedidoProduto() {
		return idPedidoProduto;
	}

	public void setIdPedidoProduto(Integer idPedidoProduto) {
		this.idPedidoProduto = idPedidoProduto;
	}

	public LocalDateTime getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(LocalDateTime dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public LocalDateTime getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(LocalDateTime dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Boolean getfAtivo() {
		return fAtivo;
	}

	public void setfAtivo(Boolean fAtivo) {
		this.fAtivo = fAtivo;
	}

	
}
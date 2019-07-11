package br.com.comprecerto.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.comprecerto.api.entities.enums.Entrega;
import br.com.comprecerto.api.entities.enums.Pagamento;
import br.com.comprecerto.api.entities.enums.Status;


@Entity
@Table(schema = "sheap", name = "pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;

	private Date dtAlteracao;
	private Date dtCriacao;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Status status;

	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Entrega entrega;
	
	@NotNull
	private BigDecimal valorFrete;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 1)
	private Pagamento pagamento;
	
	@NotNull
	private BigDecimal troco;
	
	@NotBlank
	@Length(max = 14)
	private String celular;
	
	@NotBlank
	@Length(max = 100)
	private String endereco;	
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")		
	private Date dataHorarioRetirada;	
	
	@Column(name = "f_ativo", columnDefinition = "BOOLEAN")
	private Boolean fAtivo;

	@ManyToOne	
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne	
	@JoinColumn(name="id_mercado_localidade")
	private MercadoLocalidade mercadoLocalidade;

	@OneToMany(mappedBy = "pedido", fetch= FetchType.LAZY, cascade = { CascadeType.ALL}, orphanRemoval=true)
	private List<PedidoProduto> pedidoProdutos;
	
	public Pedido() {
	}

	@PrePersist
	public void salvando() {
		dtCriacao = dtAlteracao = new Date();
		fAtivo = true;
		pedidoProdutos.forEach(pedidoProduto -> {				
			pedidoProduto.setPedido(this);
		});
	}

	@PreUpdate
	public void atualizando() {
		dtAlteracao = new Date();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public Date getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Entrega getEntrega() {
		return entrega;
	}

	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataHorarioRetirada() {
		return dataHorarioRetirada;
	}

	public void setDataHorarioRetirada(Date dataHorarioRetirada) {
		this.dataHorarioRetirada = dataHorarioRetirada;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MercadoLocalidade getMercadoLocalidade() {
		return mercadoLocalidade;
	}

	public void setMercadoLocalidade(MercadoLocalidade mercadoLocalidade) {
		this.mercadoLocalidade = mercadoLocalidade;
	}

	public List<PedidoProduto> getPedidoProdutos() {
		return pedidoProdutos;
	}

	public void setPedidoProdutos(List<PedidoProduto> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
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

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + "]";
	}

	

	
}
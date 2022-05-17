package com.facol.hardgamerstore.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

//	@ManyToOne
//	@JoinColumn(name = "produtoId")
// private Produto produtoId;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pedidoId", nullable= false)
	private List<PedidoItem> itens;
	
	@ManyToOne
	@JoinColumn(name = "clienteId")
	private Cliente clienteId;

	@Column(nullable = false)
	private double subtotal;
	@Column(length = 50, nullable = false)
	private String meioDePagamento;
	@Column(nullable = false)
	private LocalDate dataPedido = LocalDate.now();
	@Column(length = 200, nullable = false)
	private String observacoes;

	
	
	
	
	
	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

//	public Produto getProdutoId() {
//		return produtoId;
//	}

//	public void setProdutoId(Produto produtoId) {
//		this.produtoId = produtoId;
//	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getMeioDePagamento() {
		return meioDePagamento;
	}

	public void setMeioDePagamento(String meioDePagamento) {
		this.meioDePagamento = meioDePagamento;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}

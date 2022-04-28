package com.facol.hardgamerstore.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "produtoId")
    @ManyToOne
	private Produto produtoId;
	
	@JoinColumn(name = "clienteId")
    @OneToMany
	private Cliente clienteId;
	
	@Column(nullable = false)
	private double subtotal;
	@Column(length = 50, nullable = false)
	private String meioDePagamento;
	@Column(nullable = false)
	private LocalDate dataPedido = LocalDate.now();
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	@Column(length = 200, nullable = false)
	private String observacoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}
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

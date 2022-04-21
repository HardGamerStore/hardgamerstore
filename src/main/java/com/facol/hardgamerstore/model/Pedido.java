package com.facol.hardgamerstore.model;

import java.sql.Date;

public class Pedido {

	private int id;
	private Produto produto;
	private Cliente cliente;
	private double subtotal;
	private String meioDePagamento;
	private Date dataDeGeracaoDepedido;
	private String observacoes;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public Date getDataDeGeracaoDepedido() {
		return dataDeGeracaoDepedido;
	}
	public void setDataDeGeracaoDepedido(Date dataDeGeracaoDepedido) {
		this.dataDeGeracaoDepedido = dataDeGeracaoDepedido;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	
	
	
	
}

package com.facol.hardgamerstore.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Pedido {

	//@JoinColumn é responsável por fazer o atributo se juntar a coluna de outra tabela (funciona como FK).
	//ManyToOne é responsável por dizer que é um relacionamento de vários para um.
	//OneToMany é responsável por dizer que é um relacionamento de um para vários.
	
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
	private Date dataDeGeracaoDepedido;
	@Column(length = 200, nullable = false)
	private String observacoes;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List carrinho) {
		this.carrinho = carrinho;
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

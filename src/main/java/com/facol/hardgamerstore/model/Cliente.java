package com.facol.hardgamerstore.model;

public class Cliente extends Pessoa {

	private int id;
	private String carrinho;
	private Pedido pedido;
	
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(String carrinho) {
		this.carrinho = carrinho;
	}
	
	
	
}

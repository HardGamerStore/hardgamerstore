package com.facol.hardgamerstore.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.RepositorioPedido;
import com.facol.hardgamerstore.modelo.Cliente;
import com.facol.hardgamerstore.modelo.Pedido;
import com.facol.hardgamerstore.modelo.PedidoItem;
import com.facol.hardgamerstore.modelo.Produto;

@SuppressWarnings("serial")
@SessionScoped
@Named("controladorPedido")
public class ControladorPedido implements Serializable {

	
	@Inject
	private RepositorioPedido repPedido;

	private List<Pedido> pedidos;

	private String observacoes, meioDePagamento;
    private Produto produtoId;
    private Cliente clienteId;
    private double subtotal;
    
	public String cadastrar() {

		Pedido pedido = new Pedido();
		pedido.setObservacoes(observacoes);
		pedido.setMeioDePagamento(meioDePagamento);
	
		List<PedidoItem> itens = new ArrayList<>();
		PedidoItem item1 = new PedidoItem();
		item1.setProdutoId(produtoId);
		
		//	pedido.setProdutoId(produtoId);
		pedido.setClienteId(clienteId);
		pedido.setSubtotal(subtotal);
		

		this.repPedido.criar(pedido);
		this.listar();
		return "/restrito/listar.xhtml?faces-redirect=true";

	}
	public void limpar() {
		this.clienteId = null;
		this.meioDePagamento = null;
		this.observacoes=null;
		this.pedidos=null;
		this.produtoId=null;
		this.subtotal=0;
		
	}
	
	public void listar() {
		this.pedidos = this.repPedido.listar();
	}
	
	public String remover(Pedido pedido) {
		this.repPedido.remover(pedido);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Pedido removido com sucesso", ""));
		this.listar();
		return null;
	}
	
	
	
	
	
	
	public RepositorioPedido getRepPedido() {
		return repPedido;
	}
	public void setRepPedido(RepositorioPedido repPedido) {
		this.repPedido = repPedido;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getMeioDePagamento() {
		return meioDePagamento;
	}
	public void setMeioDePagamento(String meioDePagamento) {
		this.meioDePagamento = meioDePagamento;
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
	
	
	
	
	
	
}

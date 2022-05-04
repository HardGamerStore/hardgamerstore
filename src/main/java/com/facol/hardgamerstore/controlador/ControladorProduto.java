package com.facol.hardgamerstore.controlador;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.RepositorioProduto;
import com.facol.hardgamerstore.modelo.Produto;


@SessionScoped
@Named("controladorProduto")
public class ControladorProduto implements Serializable {

	@Inject
	private RepositorioProduto repProduto;

	private List<Produto> produtos;

	private String descricao, unidadeDeMedida,caracteristica,categoria;
    private int estoque;
    private double precoDeCusto,precoDeVenda;
    
	public String cadastrar() {

		Produto produto = new Produto();
		produto.setEstoque(estoque);
		produto.setPrecoDeCusto(precoDeCusto);
		produto.setPrecoDeVenda(precoDeVenda);
		produto.setCategoriaId(categoria);
		produto.setCaracteristica(caracteristica);		
		produto.setDescricao(this.descricao);
		produto.setUnidadeDeMedida(this.unidadeDeMedida);

		this.repProduto.criar(produto);
		this.listar();
		return "/listar.xhtml";

	}
	public void limpar() {
		this.descricao = null;
		this.unidadeDeMedida = null;
	}
	
	public void listar() {
		this.produtos = this.repProduto.listar();
	}
	
	public String remover(Produto produto) {
		this.repProduto.remover(produto);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto removido com sucesso", ""));
		this.listar();
		return null;
	}
	
	
	
	
	
	public RepositorioProduto getRepProduto() {
		return repProduto;
	}
	public void setRepProduto(RepositorioProduto repProduto) {
		this.repProduto = repProduto;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	
	
	
	
	
}

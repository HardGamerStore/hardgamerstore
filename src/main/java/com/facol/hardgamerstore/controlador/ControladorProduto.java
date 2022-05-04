package com.facol.hardgamerstore.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.CategoriaRepositorio;
import com.facol.hardgamerstore.dados.RepositorioProduto;
import com.facol.hardgamerstore.modelo.Categoria;
import com.facol.hardgamerstore.modelo.Produto;


@SessionScoped
@Named("controladorProduto")
public class ControladorProduto implements Serializable {

	@Inject
	private RepositorioProduto repProduto;
	@Inject
	private CategoriaRepositorio catRepositorio;

	private List<Produto> produtos;
	
	private String descricao, unidadeDeMedida,caracteristica;
    private int estoque;
    private double precoDeCusto,precoDeVenda;
    
    private Categoria categoria;
    private Long categoriaId;
    
    
	public String cadastrar() {

		Produto produto = new Produto();
		produto.setEstoque(estoque);
		produto.setPrecoDeCusto(precoDeCusto);
		produto.setPrecoDeVenda(precoDeVenda);
		
		if (this.categoriaId != null) {
			Categoria categoria = this.catRepositorio.encontrarPorId(this.categoriaId);
			produto.setCategoriaId(categoria);
//			produto.setCategoriaId(categoria);
		}

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
	
	public List<SelectItem> listarCategorias() {
		List<SelectItem> result = new ArrayList<SelectItem>();
		List<Categoria> categorias = this.catRepositorio.listar();
		if (categorias != null && !categorias.isEmpty()) {
			for (Categoria categoria : categorias) {
				result.add(new SelectItem(categoria.getId(), categoria.getNome()));
			}
		}
		return result;
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
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public double getPrecoDeCusto() {
		return precoDeCusto;
	}
	public void setPrecoDeCusto(double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}
	public double getPrecoDeVenda() {
		return precoDeVenda;
	}
	public void setPrecoDeVenda(double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	public Long getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	
	
	
	
}

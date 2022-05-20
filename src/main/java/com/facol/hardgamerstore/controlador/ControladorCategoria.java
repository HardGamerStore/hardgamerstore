package com.facol.hardgamerstore.controlador;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.RepositorioCategoria;
import com.facol.hardgamerstore.modelo.Categoria;

@SuppressWarnings("serial")
@SessionScoped
@Named("controladorCategoria")
public class ControladorCategoria implements Serializable {


	@Inject
	private RepositorioCategoria catRep;
	
	private List<Categoria> categorias;
	Categoria categoria = new Categoria();
	private String nome;
	
	
	public String salvar(){
	
		Categoria c = new Categoria();
		
		c.setNome(this.nome);
		
		catRep.criar(c);
		
		this.listar();
		
		return "/restrito/listarCategoria.xhtml?faces-redirect=true";
	}
	
	public String remover(Categoria categoria) {
		this.catRep.remover(categoria);
		this.listar();
		return null;
	}
	
	public String alterar() {
		categoria.setNome(this.nome);
		return "/restrito/listarCategoria.xhtml?faces-redirect=true";
	}
	
	public String encontrarPorId(Long idCategoria) {

		categoria = this.catRep.encontrarPorId(idCategoria);
		nome = this.categoria.getNome();

		return "/restrito/formAlterarCategoria.xhtml?faces-redirect=true";
	}
	
	
	
	public List<Categoria> listar() {
	
		this.categorias=catRep.listar();
		
		return categorias;
		
	}
	
	
	
	//GET AND SETS
	public RepositorioCategoria getCatRep() {
		return catRep;
	}


	public void setCatRep(RepositorioCategoria catRep) {
		this.catRep = catRep;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	
	

}

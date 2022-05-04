package com.facol.hardgamerstore.controlador;



import java.io.Serializable;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.facol.hardgamerstore.dados.CategoriaRepositorio;
import com.facol.hardgamerstore.modelo.Categoria;

@SuppressWarnings("serial")
@SessionScoped
@Named("controladorCategoria")
public class ControladorCategoria implements Serializable {


	@Inject
	private CategoriaRepositorio catRep;
	
	private List<Categoria> categorias;
	
	private String nome;
	
	
	public String salvar(){
	
		Categoria c = new Categoria();
		
		c.setNome(this.nome);
		
		catRep.criar(c);
		
		this.listar();
		
		return "/listarCategoria.xhtml";
	}
	
	
	
	
	
	public List<Categoria> listar() {
	
		this.categorias=catRep.listar();
		
		return categorias;
		
	}
	
	
	
	//GET AND SETS
	public CategoriaRepositorio getCatRep() {
		return catRep;
	}


	public void setCatRep(CategoriaRepositorio catRep) {
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

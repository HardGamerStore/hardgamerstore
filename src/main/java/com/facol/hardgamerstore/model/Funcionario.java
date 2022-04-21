package com.facol.hardgamerstore.model;

public class Funcionario extends Pessoa {

	private int id;
	private String funcao;
	private boolean permissoes;
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public boolean isPermissoes() {
		return permissoes;
	}
	public void setPermissoes(boolean permissoes) {
		this.permissoes = permissoes;
	}
	
	
	
	
}

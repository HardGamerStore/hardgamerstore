package com.facol.hardgamerstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa {

	@Column(length = 50, nullable = false)
	private String funcao;
	@Column(nullable = false)
	private boolean permissoes;
	
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

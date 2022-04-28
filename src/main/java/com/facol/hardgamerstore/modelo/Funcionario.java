package com.facol.hardgamerstore.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

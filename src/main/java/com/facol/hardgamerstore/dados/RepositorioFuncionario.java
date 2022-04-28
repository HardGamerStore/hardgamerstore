package com.facol.hardgamerstore.dados;

import java.util.List;


import com.facol.hardgamerstore.model.Funcionario;

public class RepositorioFuncionario extends RepositorioGenerico<Funcionario>{

	
	@Override
	public void salvar(Funcionario funcionario) {
		this.salvar(funcionario);
	}
	
	@Override
	public Funcionario buscar(long id) {
		return this.buscar(id);
	}
	
	@Override
	public void excluir(Funcionario funcionario) {
		this.excluir(funcionario);
	}
	
	@Override
	public void alterar(Funcionario funcionario) {
		this.alterar(funcionario);
	}
	
	@Override
	public List<Funcionario> listar() {
		return this.listar();
	}
	
	
}

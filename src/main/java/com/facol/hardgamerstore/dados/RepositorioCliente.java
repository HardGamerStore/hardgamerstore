package com.facol.hardgamerstore.dados;

import java.util.List;

import com.facol.hardgamerstore.model.Cliente;

public class RepositorioCliente extends RepositorioGenerico<Cliente> {
	
	@Override
	public void salvar(Cliente cliente) {
		this.salvar(cliente);
	}
	
	@Override
	public Cliente buscar(long id) {
		return this.buscar(id);
	}
	
	@Override
	public void excluir(Cliente cliente) {
		this.excluir(cliente);
	}
	
	@Override
	public void alterar(Cliente cliente) {
		this.alterar(cliente);
	}
	
	@Override
	public List<Cliente> listar() {
		return this.listar();
	}

}

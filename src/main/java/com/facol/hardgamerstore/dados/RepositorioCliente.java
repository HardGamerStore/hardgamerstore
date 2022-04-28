package com.facol.hardgamerstore.dados;

import java.util.List;

import com.facol.hardgamerstore.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class RepositorioCliente {
	
	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;
	
	public void criar(Cliente cliente) {
		this.entityManager.persist(cliente);
	}
	
	public void alterar(Cliente cliente) {
		this.entityManager.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		List<Cliente> result = null;
		Query query = this.entityManager.createQuery("FROM Cliente entity");
		result = query.getResultList();
		
		return result;
	}

	public void remover(Cliente cliente) {
		Query query = this.entityManager.createQuery("FROM Cliente entity WHERE entity.id = :id");
		query.setParameter("id", cliente.getId());
		Cliente removeCliente = (Cliente)query.getSingleResult();
		this.entityManager.remove(removeCliente);
	}
}
package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Funcionario;
import com.facol.hardgamerstore.modelo.Pedido;

public class RepositorioFuncionario extends RepositorioGenerico<Funcionario> {

	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	
	@SuppressWarnings("unchecked")
	public List<Pedido> listaPedidos() {
		 return (List<Pedido>) entityManager.createQuery("FROM Pedido entity WHERE entity.id = :id").getResultList();
		 }

	
	@SuppressWarnings("unchecked")
	public List<Funcionario> listar() {
		List<Funcionario> result = null;
		Query query = this.entityManager.createQuery("FROM Funcionario entity");
		result = query.getResultList();
		
		return result;
	}

	public void remover(Funcionario funcionario) {
		Query query = this.entityManager.createQuery("FROM Funcionario entity WHERE entity.id = :id");
		query.setParameter("id", funcionario.getId());
		Funcionario removeFuncionario = (Funcionario)query.getSingleResult();
		this.entityManager.remove(removeFuncionario);
	}	

	
	
	
}

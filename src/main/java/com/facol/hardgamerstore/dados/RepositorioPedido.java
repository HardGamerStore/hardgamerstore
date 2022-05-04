package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Pedido;

@Stateless
public class RepositorioPedido extends RepositorioGenerico<Pedido> {

	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listar() {
		List<Pedido> result = null;
		Query query = this.entityManager.createQuery("FROM Pedido entity");
		result = query.getResultList();
		
		return result;
	}

	
	public void remover(Pedido pedido) {
		Query query = this.entityManager.createQuery("FROM Pedido entity WHERE entity.id = :id");
		query.setParameter("id", pedido.getId());
		Pedido removeProduto = (Pedido)query.getSingleResult();
		this.entityManager.remove(removeProduto);
	}
}

package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Cliente;
import com.facol.hardgamerstore.modelo.Pedido;

<<<<<<< Updated upstream
public class RepositorioCliente {
	
=======
@Stateless
public class RepositorioCliente extends RepositorioGenerico<Cliente> {

>>>>>>> Stashed changes
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
	
	@SuppressWarnings("unchecked")
	public List<Pedido> listaPedidosPorCliente() {
		 return (List<Pedido>) this.entityManager.createQuery("FROM Pedido entity WHERE entity.idCliente = :idCliente").getResultList();
		 }

	public void remover(Cliente cliente) {
		Query query = this.entityManager.createQuery("FROM Cliente entity WHERE entity.id = :id");
		query.setParameter("id", cliente.getId());
		Cliente removeCliente = (Cliente)query.getSingleResult();
		this.entityManager.remove(removeCliente);
	}
}
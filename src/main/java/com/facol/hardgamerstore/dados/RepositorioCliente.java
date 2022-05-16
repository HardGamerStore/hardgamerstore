package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Cliente;
import com.facol.hardgamerstore.modelo.Pedido;

@Stateless
public class RepositorioCliente extends RepositorioGenerico<Cliente> {

	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listar() {
		try {
			List<Cliente> result = null;
			Query query = this.entityManager.createQuery("FROM Cliente entity");
			result = query.getResultList();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public Cliente validate(String login, String senha) {

	      try {
	        Cliente cliente = (Cliente)
	         this.entityManager.createQuery("SELECT u from Cliente u where u.login = :login and u.senha = :senha")
	         .setParameter("login", login)
	         .setParameter("senha", senha).getSingleResult();
	        //System.out.println(cliente.getBairro() + cliente.getCpf());

	        return cliente;
	      } catch (NoResultException e) {
	            return null;
	      }
	    }

	public Cliente encontrarPorId(Long clienteId) {
		Query query = this.entityManager.createQuery("FROM Cliente entity WHERE entity.id = :id");
		query.setParameter("id", clienteId);
		Cliente cliente = (Cliente) query.getSingleResult();
		return cliente;

	}

	@SuppressWarnings("unchecked")
	public List<Pedido> listaPedidosPorCliente(int idCliente) {
		Query query = this.entityManager.createQuery("FROM Pedido entity WHERE entity.idCliente = :idCliente");
		query.setParameter("idCliente", idCliente);
		return (List<Pedido>) query.getResultList();
	}

	public void remover(Cliente cliente) {
		Query query = this.entityManager.createQuery("FROM Cliente entity WHERE entity.id = :id");
		query.setParameter("id", cliente.getId());
		Cliente removeCliente = (Cliente) query.getSingleResult();
		this.entityManager.remove(removeCliente);
	}

}
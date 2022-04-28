package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Pedido;

public class RepositorioPedido {

	
	
	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;
	
	public void criar(Pedido pedido) {
		this.entityManager.persist(pedido);
	}
	
	public void alterar(Pedido pedido) {
		this.entityManager.merge(pedido);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public ArrayList<Pedido> listarTodos() {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Pedido> cq = cb.createQuery(Pedido.class);
			Root<Pedido> rootEntry = cq.from(Pedido.class);
			CriteriaQuery<Pedido> all = cq.select(rootEntry);
			TypedQuery<Pedido> allQuery = em.createQuery(all);
			System.out.println("LISTANDO... ");
			return new ArrayList<Pedido>(allQuery.getResultList());

		} catch (RuntimeException e) {
			System.out.println("erro" + e.toString());

			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
	}

	
	
	public void salvar(Pedido pedido) {

		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.persist(pedido);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO SALVAR... " + e.toString());
			if (tran != null)
				tran.rollback();
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}
	}

	
	
	public Pedido buscar(long id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			 
			 CriteriaBuilder builder = emf.getCriteriaBuilder();
			 CriteriaQuery<Pedido> crit = builder.createQuery(Pedido.class);
			 Pedido pedido= (Pedido) em.createQuery("FROM br.projetodenunciaweb.entidade.Cliente c WHERE c.id = :id")
					 .setParameter("id", id).getSingleResult();				 
			return pedido;
			
		 
		} catch (RuntimeException e) {
			System.out.println("CONSULTAR CLIENTE POR ID... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
			
		 
	}

	
	
	
	public void excluir(Produto produto) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.remove(produto);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO DELETAR... " + e.toString());
			if (tran != null)
				tran.rollback();
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}

	}

	
	public void alterar(Produto produto) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.merge(produto);
			tran.commit();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO EDITAR... " + e.toString());
			if (tran != null)
				tran.rollback();
			throw e;
		} finally {
			if (em != null) {
				em.close();
				emf.close();
			}
		}

	}*/
	
	
}

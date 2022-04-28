package com.facol.hardgamerstore.dados;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Produto;

public class RepositorioProduto {
	

	
	
	@PersistenceContext(name = "hardgamerstore")
	private EntityManager entityManager;
	
	public void criar(Produto produto) {
		this.entityManager.persist(produto);
	}
	
	public void alterar(Produto produto) {
		this.entityManager.merge(produto);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar() {
		List<Produto> result = null;
		Query query = this.entityManager.createQuery("FROM Cliente entity");
		result = query.getResultList();
		
		return result;
	}

	
	public void remover(Produto produto) {
		Query query = this.entityManager.createQuery("FROM Produto entity WHERE entity.id = :id");
		query.setParameter("id", produto.getId());
		Produto removeProduto = (Produto)query.getSingleResult();
		this.entityManager.remove(removeProduto);
	}
	
	
	
	

	
	
	
	
	
	
	
	/*public ArrayList<Produto> listarTodos() {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Produto> cq = cb.createQuery(Produto.class);
			Root<Produto> rootEntry = cq.from(Produto.class);
			CriteriaQuery<Produto> all = cq.select(rootEntry);
			TypedQuery<Produto> allQuery = em.createQuery(all);
			System.out.println("LISTANDO... ");
			return new ArrayList<Produto>(allQuery.getResultList());

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

	
	
	public void salvar(Produto produto) {

		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.persist(produto);
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

	
	
	public Produto buscar(long id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
			em = emf.createEntityManager();
			 
			 CriteriaBuilder builder = emf.getCriteriaBuilder();
			 CriteriaQuery<Produto> crit = builder.createQuery(Produto.class);
			 Produto produto= (Produto) em.createQuery("FROM br.projetodenunciaweb.entidade.Cliente c WHERE c.id = :id")
					 .setParameter("id", id).getSingleResult();				 
			return produto;
			
		 
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
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
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
			emf = Persistence.createEntityManagerFactory("persistenciaweb");
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

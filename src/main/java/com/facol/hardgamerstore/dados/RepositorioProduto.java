package com.facol.hardgamerstore.dados;

import java.util.ArrayList;
import java.util.List;

import com.facol.hardgamerstore.model.Pedido;
import com.facol.hardgamerstore.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class RepositorioProduto extends RepositorioGenerico<Produto>{
	
	@Override
	public void salvar(Produto produto) {
		this.salvar(produto);
	}
	
	@Override
	public Produto buscar(long id) {
		return this.buscar(id);
	}
	
	@Override
	public void excluir(Produto produto) {
		this.excluir(produto);
	}
	
	@Override
	public void alterar(Produto produto) {
		this.alterar(produto);
	}
	
	@Override
	public List<Produto> listar() {
		return this.listar();
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

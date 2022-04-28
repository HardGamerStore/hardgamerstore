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

public class RepositorioPedido extends RepositorioGenerico<Pedido> {

	
	@Override
	public void salvar(Pedido pedido) {
		this.salvar(pedido);
	}
	
	@Override
	public Pedido buscar(long id) {
		return this.buscar(id);
	}
	
	@Override
	public void excluir(Pedido pedido) {
		this.excluir(pedido);
	}
	
	@Override
	public void alterar(Pedido pedido) {
		this.alterar(pedido);
	}
	
	@Override
	public List<Pedido> listar() {
		return this.listar();
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

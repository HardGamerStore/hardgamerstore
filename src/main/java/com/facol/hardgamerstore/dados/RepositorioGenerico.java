package com.facol.hardgamerstore.dados;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.facol.hardgamerstore.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class RepositorioGenerico<Entidade> {

	private Class<Entidade> classeEntidade;

	public RepositorioGenerico() {
		System.out.println("Classe: " + getClass().getGenericSuperclass().toString());
		this.classeEntidade = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public List<Entidade> listar() {

		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();

			CriteriaBuilder critBuilder = em.getCriteriaBuilder();
			CriteriaQuery<Entidade> critQuery = critBuilder.createQuery(classeEntidade);
			Root<Entidade> rootEntry = critQuery.from(classeEntidade);
			CriteriaQuery<Entidade> all = critQuery.select(rootEntry);

			TypedQuery<Entidade> allQuery = em.createQuery(all);
			return allQuery.getResultList();

		} catch (RuntimeException e) {
			System.out.println("ERRO AO LISTAR... " + e.toString());
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void salvar(Entidade entidade) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.persist(entidade);
			tran.commit();

		} catch (RuntimeException e) {
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

	public Entidade buscar(long id) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();

			Entidade result = (Entidade) em.find(getClass(), id);
			return result;

		} catch (RuntimeException e) {
			throw e;
		} finally {
			em.close();
			emf.close();
		}
	}

	public void excluir(Entidade entidade) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.remove(entidade);
			tran.commit();

		} catch (RuntimeException e) {
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

	public void alterar(Entidade entidade) {
		EntityTransaction tran = null;
		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("hardgamerstore");
			em = emf.createEntityManager();
			tran = em.getTransaction();
			tran.begin();
			em.merge(entidade);
			tran.commit();

		} catch (RuntimeException e) {
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
}
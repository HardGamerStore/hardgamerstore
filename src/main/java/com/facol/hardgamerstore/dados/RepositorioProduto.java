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
		Query query = this.entityManager.createQuery("FROM Produto entity");
		result = query.getResultList();
		
		return result;
	}

	
	public void remover(Produto produto) {
		Query query = this.entityManager.createQuery("FROM Produto entity WHERE entity.id = :id");
		query.setParameter("id", produto.getId());
		Produto removeProduto = (Produto)query.getSingleResult();
		this.entityManager.remove(removeProduto);
	}
}

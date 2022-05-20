package com.facol.hardgamerstore.dados;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.facol.hardgamerstore.modelo.Categoria;
import com.facol.hardgamerstore.modelo.Cliente;

@Stateless
public class RepositorioCategoria {

	@PersistenceContext(name = "testeProduto")
	private EntityManager entityManager;
	
	public void criar(Categoria categoria) {
		this.entityManager.persist(categoria);
	}
	
	public void alterar(Categoria categoria) {
		this.entityManager.merge(categoria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		List<Categoria> result = null;
		Query query = this.entityManager.createQuery("FROM Categoria entity");
		result = query.getResultList();
		
		return result;
	}
	
	public void remover(Categoria categoria) {
		Query query = this.entityManager.createQuery("FROM Categoria entity WHERE entity.id = :id");
		query.setParameter("id", categoria.getId());
		Categoria removeCategoria = (Categoria)query.getSingleResult();
		this.entityManager.remove(removeCategoria);
	}

	public Categoria encontrarPorId(Long categoriaId) {
		Query query = this.entityManager.createQuery("FROM Categoria entity WHERE entity.id = :id");
		query.setParameter("id", categoriaId);
		Categoria categoria = (Categoria)query.getSingleResult();
		return categoria;
	}
}

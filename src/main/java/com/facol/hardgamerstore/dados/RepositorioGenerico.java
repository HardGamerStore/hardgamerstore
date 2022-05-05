package com.facol.hardgamerstore.dados;

import javax.persistence.EntityManager;

public abstract class RepositorioGenerico <T> {
	
	public abstract EntityManager getEntityManager();

	public void criar(T t) {
		this.getEntityManager().persist(t);
	}
	
	public void alterar(T t) {
		
		this.getEntityManager().merge(t);
	}
	
}

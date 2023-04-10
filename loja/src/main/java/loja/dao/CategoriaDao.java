package loja.dao;

import javax.persistence.EntityManager;

import loja.modelo.Categoria;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void Cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
}

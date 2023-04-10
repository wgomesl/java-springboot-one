package loja.dao;

import javax.persistence.EntityManager;

import loja.modelo.Produto;

public class ProdutoDao {
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void Cadastrar(Produto produto) {
		this.em.persist(produto);
	}
}

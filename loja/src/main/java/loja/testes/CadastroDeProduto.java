package loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import loja.dao.ProdutoDao;
import loja.modelo.Produto;
import loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		
		Produto celular = new Produto();
		celular.setNome("Xiaomi Redmi");
		celular.setDescricao("Muito legal");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.Cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}

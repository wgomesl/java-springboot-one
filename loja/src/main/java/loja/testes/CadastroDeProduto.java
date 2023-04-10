package loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import loja.dao.CategoriaDao;
import loja.dao.ProdutoDao;
import loja.modelo.Categoria;
import loja.modelo.Produto;
import loja.util.JPAUtil;

public class CadastroDeProduto {
	public static void main(String[] args) {
		
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto p = produtoDao.buscarPorId(1l);
		System.out.println(p.getPreco());
		
		List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));
		
		BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
		System.out.println("Preço do Produto : " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.Cadastrar(celulares);
		produtoDao.Cadastrar(celular);
		
		em.getTransaction().commit();
		em.close();
	}
}

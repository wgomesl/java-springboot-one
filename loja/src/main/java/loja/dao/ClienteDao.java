package loja.dao;
import javax.persistence.EntityManager;
import loja.modelo.Cliente;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void Cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
}

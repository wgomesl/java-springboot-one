package loja.dao;
import javax.persistence.EntityManager;
import loja.modelo.Pedido;

public class PedidoDao {
	
	private EntityManager em;

	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	public void Cadastrar(Pedido pedido) {
		this.em.persist(pedido);
	}
}

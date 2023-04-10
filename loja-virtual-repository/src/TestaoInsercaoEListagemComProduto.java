import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaoInsercaoEListagemComProduto {
	public static void main(String[] args) throws SQLException {
		Produto comoda = new Produto("Cômoda", "Cômoda vertical");
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvarProduto(comoda);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
	}

  }
}

package gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Resilia");
		Empresa empresa3 = new Empresa();
		empresa3.setNome("Capgemini");
		Empresa empresa4 = new Empresa();
		empresa4.setNome("Dio");
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
		lista.add(empresa4);
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
}

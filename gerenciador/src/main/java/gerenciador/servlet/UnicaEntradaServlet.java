package gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.acao.AlteraEmpresa;
import gerenciador.acao.ListaEmpresas;
import gerenciador.acao.MostraEmpresa;
import gerenciador.acao.NovaEmpresa;
import gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		String nome = null;
		if(paramAcao.equals("ListaEmpresas")) {
			
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("RemoveEmpresa")) {	
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);
			
		}else if(paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		}
		
		String[] tipoAndEndereco = nome.split(":");
		
		if(tipoAndEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoAndEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoAndEndereco[1]);
		}
	}

}

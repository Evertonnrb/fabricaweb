package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

//url http://localhost:8080/fabricaweb/usucontroller.do
@WebServlet("/usucontroller.do")
// adicionando a dependencia da servlet atravez do pom
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		// TODO Auto-generated constructor stub
		System.out.println("Chamou o construtor...");
	}

	private void inti() {
		// TODO Auto-generated method stub
		System.out.println("Chamou o init..");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Chamou o destroy...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		//Iformando a servlet que ela deve interpretar html
		resp.setContentType("text/html");
		
		if (acao.equals("excluir")) {
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			if (id != null)
				usu.setId(Integer.parseInt(id));
			UsuarioDao usuDao = new UsuarioDao();
			usuDao.excluir(usu);

			resp.getWriter().print("Excluido com sucesso");
		}else if(acao.equals("lista")){
			UsuarioDao usuDao  =  new UsuarioDao();
			List<Usuario>lista = usuDao.buscarTodos();
			//resp.getWriter().print(lista+"</br>");;
//			for(Usuario u :lista){
//				resp.getWriter().print(u.getNome()+"<br>");
//			}
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("listausu.jsp");
			dispatcher.forward(req, resp);
		}
		//
		// //Passando parametros atraves sa requisisao doGet(caso de test)
		// String nome = req.getParameter("nome");
		// String login = req.getParameter("login");
		// String senha = req.getParameter("senha");
		//
		// //Instnciando um usuario para armazenar os parametros
		// Usuario usu = new Usuario();
		// usu.setNome(nome);
		// usu.setLogin(login);
		// usu.setSenha(senha);
		//
		// UsuarioDao usuDao = new UsuarioDao();
		// usuDao.cadastrar(usu);

		System.out.println("cadastrado com sucesso...");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Passando parametros atraves sa requisisao doGet(caso de test)
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		// Instnciando um usuario para armazenar os parametros
		Usuario usu = new Usuario();
		if (id != null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		UsuarioDao usuDao = new UsuarioDao();
		usuDao.cadastrar(usu);

		// enviando resposta para o browser
		resp.getWriter().print("<h1>cadastrado com sucessso</h1>");
	}
}

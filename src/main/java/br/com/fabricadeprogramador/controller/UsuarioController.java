package br.com.fabricadeprogramador.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

//url http://localhost:8080/fabricaweb/usucontroller.do
@WebServlet("/usucontroller.do")
//adicionando a dependencia da servlet atravez do pom
public class UsuarioController extends HttpServlet{

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
//			
//		//Passando parametros atraves sa requisisao doGet(caso de test)
//		String nome = req.getParameter("nome");
//		String login = req.getParameter("login");
//		String senha = req.getParameter("senha");
//		
//		//Instnciando um usuario para armazenar os parametros
//		Usuario usu =  new Usuario();
//		usu.setNome(nome);
//		usu.setLogin(login);
//		usu.setSenha(senha);
//		
//		UsuarioDao usuDao = new UsuarioDao();
//		usuDao.cadastrar(usu);
		
		System.out.println("cadastrado com sucesso...");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//Passando parametros atraves sa requisisao doGet(caso de test)
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		//Instnciando um usuario para armazenar os parametros
		Usuario usu =  new Usuario();
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.cadastrar(usu);
		
		//enviando resposta para o browser
		resp.getWriter().print("<h1>cadastrado com sucessso</h1>");
	}
}

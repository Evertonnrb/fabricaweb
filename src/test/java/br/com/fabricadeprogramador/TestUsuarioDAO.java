package br.com.fabricadeprogramador;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.fabricadeprogramador.entidades.Usuario;
import br.com.fabricadeprogramador.persistencia.UsuarioDao;

public class TestUsuarioDAO {
	public static void main(String[] args) {
		// testCadastrar();
		//testAlterar();
		//testExcluir();
		//testSalvar();
		testBuscarPorId();
	}

	public static void testCadastrar() {
		// Criando intancia de usuario
		Usuario usu = new Usuario();
		usu.setNome("Jao");
		usu.setLogin("JJ");
		usu.setSenha("@123");
		// Instanciando usuario DAO
		UsuarioDao usuDao = new UsuarioDao();
		// cadastrando o usuario atraves do método cadastrar do UsuarioDao
		usuDao.cadastrar(usu);
		JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

	}

	public static void testAlterar() {
		// Criando intancia de usuario
		Usuario usu = new Usuario();
		usu.setId(2);
		usu.setNome("Brunna Surfinha");
		usu.setLogin("brunninha");
		usu.setSenha("69");
		// Instanciando usuario DAO
		UsuarioDao usuDao = new UsuarioDao();
		// cadastrando o usuario atraves do método cadastrar do UsuarioDao
		usuDao.alterar(usu);
		JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
	}
	public static void testExcluir(){
		Usuario usu = new Usuario();
		usu.setId(4);
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.excluir(usu);
		JOptionPane.showMessageDialog(null, "Ususario excluído com sucesso");
	}
	public static void testSalvar(){
		Usuario usu = new Usuario();
		usu.setId(3);
		usu.setNome("Rita cadilac");
		usu.setLogin("carro");
		usu.setSenha("@123");
		UsuarioDao usuDao = new UsuarioDao();
		usuDao.salvar(usu);
		JOptionPane.showMessageDialog(null, "Usúario salvo com sucesso");
	}
	public static void testBuscarPorId(){
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usuario = usuDao.buscarPorId(2);
		JOptionPane.showMessageDialog(null, usuario);
		System.out.println(usuario);
	}
	public static void testBuscarTodos(){
		UsuarioDao usuDao = new UsuarioDao();
		List<Usuario> lista = usuDao.buscarTodos();
		for (Usuario u: lista) {
			JOptionPane.showMessageDialog(null, usuDao);
			System.out.println();
		}
		
	}
}

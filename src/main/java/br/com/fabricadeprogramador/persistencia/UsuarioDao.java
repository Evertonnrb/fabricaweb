package br.com.fabricadeprogramador.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.fabricadeprogramador.entidades.Usuario;

public class UsuarioDao {
	// utilizando a variavel con que aponta para a classe Conexão factory para
	// fazer a conexão com o banco
	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		// Montando a String sql
		String sql = "insert into usuario(nome,login,senha)values(?,?,?)";
		try {
			// Intanciando preparede statment para persistir os dados atravez da
			// conexao con
			PreparedStatement pst = con.prepareStatement(sql);
			// setando os parametros para a persistência
			pst.setString(1, usu.getNome());
			pst.setString(2, usu.getLogin());
			pst.setString(3, usu.getSenha());
			// executando a string
			pst.execute();
			// fechando a conexão
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=?,login=?,senha=? where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, usu.getNome());
			pst.setString(2, usu.getLogin());
			pst.setString(3, usu.getSenha());
			pst.setInt(4, usu.getId());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void excluir(Usuario usu) {
		String sql = "delete from usuario where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1, usu.getId());
			pst.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

package br.com.fabricadeprogramador.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

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
	public void salvar(Usuario usu){
		//Aplicando uma condiçao para saber que tipo de solicitaçao está chegando
		//se id existir no banco == alterar() se nao existir salvar()
		if(usu.getId()!=null){
			alterar(usu);
		}
		else{
			cadastrar(usu);
		}
			
	}
	public Usuario buscarPorId(Integer id){
		String sql = "select*from usuario where id=?";
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setInt(1,id);
			ResultSet res  = pst.executeQuery();
			//Posicionand
			res.next();
			//verificando se p res chegara vazio
			if(res.next()){
				Usuario usu = new Usuario();
				usu.setId(res.getInt("id"));
				usu.setNome(res.getString("nome"));
				usu.setLogin(res.getString("login"));
				usu.setSenha(res.getString("senha"));	
				return usu	;
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public List<Usuario> buscarTodos(){
		String sql = "select*from usuario";
		List<Usuario>lista = new ArrayList<Usuario>();
		try (PreparedStatement pst = con.prepareStatement(sql)){
			
			ResultSet res  = pst.executeQuery();
			//Posicionand
			//res.next();
			//verificando se p res chegara vazio
			while(res.next()){
				Usuario usu = new Usuario();
				usu.setId(res.getInt("id"));
				usu.setNome(res.getString("nome"));
				usu.setLogin(res.getString("login"));
				usu.setSenha(res.getString("senha"));	
				lista.add(usu);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
	}
	public Usuario autenticar(Usuario usuConsulta){
		String sql = "select*from usuario where id=? and senha=?";
		try (PreparedStatement pst = con.prepareStatement(sql)){
			pst.setString(1, usuConsulta.getLogin());
			pst.setString(2,usuConsulta.getSenha());
			ResultSet res = pst.executeQuery();
			
			if(res.next()){
			Usuario usu = new Usuario();
			usu.setId(res.getInt("id"));
			usu.setNome(res.getString("nome"));
			usu.setLogin(res.getString("login"));
			usu.setSenha(res.getString("senha"));
			return usu;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}

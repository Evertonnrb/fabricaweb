package br.com.fabricadeprogramador.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		// Criando a conexao com o banco
		try {
			//forçando o carregamento do driver 
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","postgres");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error ao conectar ao banco "+e);
			throw new RuntimeException(e);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
}

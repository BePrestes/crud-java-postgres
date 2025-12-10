package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String URL = "jdbc:postgresql://localhost:5432/crudpg";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "@Bernardo0205";

	public static Connection conectar() {
		try {
			Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
			return conn;
		} catch (SQLException e) {
			System.out.println(" Erro ao conectar com o banco de dados: " + e.getMessage());
			return null;
		}
	}
}

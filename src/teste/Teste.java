package teste;

import db.Conexao;
import java.sql.Connection;

public class Teste {
	public static void main(String[] args) {
		Connection conn = Conexao.conectar();

		if (conn != null) {
			System.out.println(" Conectado ao banco de dados com sucesso!");
			try {
				conn.close();
			} catch (Exception ignored) {
			}
		} else {
			System.out.println(" Falha na conexão!");
		}
	}
}

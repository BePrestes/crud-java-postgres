package app;

import db.Conexao;
import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {
        try {
            Connection conn = Conexao.conectar();
            System.out.println("Conectado com sucesso!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro na conexão:");
            e.printStackTrace();
        }
    }
}

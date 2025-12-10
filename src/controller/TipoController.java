package controller;

import db.Conexao;
import model.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoController {

	public void cadastrar(Tipo tipo) {

		String sql = "INSERT INTO tipo (nome, descricao) VALUES (?, ?)";

		try (Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, tipo.getNome());
			stmt.setString(2, tipo.getDescricao());

			stmt.execute();
			System.out.println("Tipo cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println(" Erro ao cadastrar Tipo: " + e.getMessage());
		}
	}

	public ArrayList<Tipo> listar() {

		ArrayList<Tipo> lista = new ArrayList<>();
		String sql = "SELECT * FROM tipo";

		try (Connection conn = Conexao.conectar();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Tipo tipo = new Tipo(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"));

				lista.add(tipo);
			}

		} catch (SQLException e) {
			System.out.println(" Erro ao listar Tipos: " + e.getMessage());
		}

		return lista;
	}
}

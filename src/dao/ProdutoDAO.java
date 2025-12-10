package dao;

import db.Conexao;
import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

	public void cadastrar(Produto produto) {
		String sql = "INSERT INTO produto (id, nome, descricao, valor, unidade, ref_tipo) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = Conexao.conectar();
			if (conn == null) {
				System.out.println(" Falha na conexão ao cadastrar produto.");
				return;
			}

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, produto.getId());
			stmt.setString(2, produto.getNome());
			stmt.setString(3, produto.getDescricao());
			stmt.setDouble(4, produto.getValor());
			stmt.setString(5, produto.getUnidade());
			stmt.setInt(6, produto.getRefTipo());

			stmt.execute();
			System.out.println(" Produto cadastrado com sucesso!");

		} catch (SQLException e) {
			System.out.println(" Erro ao cadastrar produto: " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ignored) {
			}
		}
	}

	public List<Produto> listar() {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT * FROM produto";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = Conexao.conectar();
			if (conn == null) {
				System.out.println(" Falha na conexão ao listar produtos.");
				return lista;
			}

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"),
						rs.getDouble("valor"), rs.getString("unidade"), rs.getInt("ref_tipo"));
				lista.add(p);
			}

		} catch (SQLException e) {
			System.out.println(" Erro ao listar produtos: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ignored) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ignored) {
			}
		}

		return lista;
	}

	public Produto buscarPorId(int id) {
		String sql = "SELECT * FROM produto WHERE id = ?";
		Produto produto = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = Conexao.conectar();
			if (conn == null) {
				System.out.println(" Falha na conexão ao buscar produto.");
				return null;
			}

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"),
						rs.getDouble("valor"), rs.getString("unidade"), rs.getInt("ref_tipo"));
			}

		} catch (SQLException e) {
			System.out.println(" Erro ao buscar produto: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException ignored) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ignored) {
			}
		}

		return produto;
	}

	public void atualizar(Produto produto) {
		String sql = "UPDATE produto SET nome = ?, descricao = ?, valor = ?, unidade = ?, ref_tipo = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = Conexao.conectar();
			if (conn == null) {
				System.out.println(" Falha na conexão ao atualizar produto.");
				return;
			}

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, produto.getNome());
			stmt.setString(2, produto.getDescricao());
			stmt.setDouble(3, produto.getValor());
			stmt.setString(4, produto.getUnidade());
			stmt.setInt(5, produto.getRefTipo());
			stmt.setInt(6, produto.getId());

			int linhas = stmt.executeUpdate();
			if (linhas > 0) {
				System.out.println(" Produto atualizado com sucesso!");
			} else {
				System.out.println(" Produto não encontrado!");
			}

		} catch (SQLException e) {
			System.out.println(" Erro ao atualizar produto: " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ignored) {
			}
		}
	}

	public void remover(int id) {
		String sql = "DELETE FROM produto WHERE id = ?";
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = Conexao.conectar();
			if (conn == null) {
				System.out.println(" Falha na conexão ao remover produto.");
				return;
			}

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			int linhas = stmt.executeUpdate();
			if (linhas > 0) {
				System.out.println(" Produto removido com sucesso!");
			} else {
				System.out.println(" Produto não encontrado!");
			}

		} catch (SQLException e) {
			System.out.println("❌ Erro ao remover produto: " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException ignored) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException ignored) {
			}
		}
	}
}

package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;

public class ProdutoController {

	private ProdutoDAO dao = new ProdutoDAO();

	public void cadastrar(Produto produto) {
		dao.cadastrar(produto);
	}

	public List<Produto> listar() {
		return dao.listar();
	}

	public Produto buscarPorId(int id) {
		return dao.buscarPorId(id);
	}

	public void atualizar(Produto produto) {
		dao.atualizar(produto);
	}

	public void remover(int id) {
		dao.remover(id);
	}
}

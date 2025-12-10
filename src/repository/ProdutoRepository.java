package repository;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoRepository {

	public List<Produto> produtos = new ArrayList<>();

	public void salvar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> listar() {
		return produtos;
	}

	public Produto buscarPorId(int id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	public void remover(int id) {
		produtos.removeIf(produto -> produto.getId() == id);
	}
}

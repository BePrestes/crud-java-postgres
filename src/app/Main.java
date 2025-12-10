package app;

import controller.ProdutoController;
import model.Produto;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProdutoController controller = new ProdutoController();

		Produto p1 = new Produto(1, "Arroz", "Arroz branco 5kg", 25.50, "UN", 1);
		Produto p2 = new Produto(2, "Feijão", "Feijão preto 1kg", 8.90, "UN", 1);

		controller.cadastrar(p1);
		controller.cadastrar(p2);

		System.out.println("LISTA DE PRODUTOS");
		List<Produto> lista = controller.listar();

		for (Produto p : lista) {
			System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() + " | Valor: " + p.getValor());
		}

		System.out.println("BUSCAR PRODUTO PELO ID 1");
		Produto encontrado = controller.buscarPorId(1);

		if (encontrado != null) {
			System.out.println("Produto encontrado: " + encontrado.getNome());
		} else {
			System.out.println("Produto não encontrado!");
		}

		System.out.println("REMOVENDO PRODUTO ID 2");
		controller.remover(2);

		System.out.println("LISTA ATUALIZADA");
		for (Produto p : controller.listar()) {
			System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome());
		}
	}
}

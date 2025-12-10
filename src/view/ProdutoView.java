package view;

import controller.ProdutoController;
import model.Produto;
import java.util.List;
import java.util.Scanner;

public class ProdutoView {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProdutoController controller = new ProdutoController();
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n MENU PRODUTO ");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - LISTAR PRODUTOS");
            System.out.println("3 - BUSCAR PRODUTO POR ID");
            System.out.println("4 - REMOVER PRODUTO");
            System.out.println("5 - ATUALIZAR PRODUTO");
            System.out.println("6 - SAIR");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Valor: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                System.out.print("Unidade: ");
                String unidade = sc.nextLine();

                System.out.print("ID do Tipo: ");
                int refTipo = sc.nextInt();

                if (id <= 0) {
                    System.out.println("ID inválido.");
                } else if (nome == null || nome.trim().isEmpty()) {
                    System.out.println("Nome inválido.");
                } else if (valor < 0) {
                    System.out.println("Valor inválido.");
                } else {
                    Produto produto = new Produto(id, nome, descricao, valor, unidade, refTipo);
                    controller.cadastrar(produto);
                }

            } else if (opcao == 2) {
                List<Produto> lista = controller.listar();
                System.out.println("\n LISTA DE PRODUTOS ");

                if (lista.isEmpty()) {
                    System.out.println("Nenhum produto cadastrado.");
                } else {
                    for (Produto p : lista) {
                        System.out.println(
                            "ID: " + p.getId() +
                            " | Nome: " + p.getNome() +
                            " | Valor: " + p.getValor()
                        );
                    }
                }

            } else if (opcao == 3) {
                System.out.print("Digite o ID: ");
                int id = sc.nextInt();

                Produto p = controller.buscarPorId(id);

                if (p != null) {
                    System.out.println("Produto encontrado: " + p.getNome()
                        + " | Descrição: " + p.getDescricao()
                        + " | Valor: " + p.getValor()
                    );
                } else {
                    System.out.println("Produto não encontrado!");
                }

            } else if (opcao == 4) {
                System.out.print("Digite o ID para remover: ");
                int id = sc.nextInt();
                controller.remover(id);

            } else if (opcao == 5) {
                System.out.print("Digite o ID do produto: ");
                int id = sc.nextInt();
                sc.nextLine();

                Produto existente = controller.buscarPorId(id);

                if (existente == null) {
                    System.out.println("Produto não encontrado!");
                } else {
                    System.out.print("Novo nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Nova descrição: ");
                    String descricao = sc.nextLine();

                    System.out.print("Novo valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nova unidade: ");
                    String unidade = sc.nextLine();

                    System.out.print("Novo ID do Tipo: ");
                    int refTipo = sc.nextInt();

                    if (nome == null || nome.trim().isEmpty()) {
                        System.out.println("Nome inválido.");
                    } else if (valor < 0) {
                        System.out.println("Valor inválido.");
                    } else {
                        Produto atualizado = new Produto(id, nome, descricao, valor, unidade, refTipo);
                        controller.atualizar(atualizado);
                    }
                }

            } else if (opcao == 6) {
                System.out.println("Encerrando sistema...");
            } else {
                System.out.println("Opção inválida!");
            }
        }

        sc.close();
    }
}

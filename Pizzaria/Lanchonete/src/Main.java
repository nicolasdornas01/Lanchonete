import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static List<Produto> cardapio = new ArrayList<>();

    public static void main(String[] args) {
        carregarCardapio();

        System.out.println("========================================");
        System.out.println("       BEM-VINDO A LANCHONETE");
        System.out.println("========================================");

        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu endereco: ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente(nome, endereco);
        Pedido pedido = new Pedido(cliente, 8.00);

        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opcao: ");

            if (opcao >= 1 && opcao <= cardapio.size()) {
                Produto escolhido = cardapio.get(opcao - 1);
                int qtd = lerInteiro("Quantidade: ");

                if (qtd > 0) {
                    pedido.adicionarItem(escolhido, qtd);
                    System.out.println(qtd + "x " + escolhido.getNome() + " adicionado(s)!\n");
                } else {
                    System.out.println("Quantidade invalida!\n");
                }
            } else if (opcao == 0) {
                System.out.println("\nFinalizando seu pedido...");
            } else {
                System.out.println("Opcao invalida! Tente novamente.\n");
            }

        } while (opcao != 0);

        if (pedido.getItens().isEmpty()) {
            System.out.println("Nenhum item no pedido. Volte sempre!");
        } else {
            pedido.exibirResumo();
        }

        sc.close();
    }

    private static void carregarCardapio() {
        cardapio.add(new Lanche("X-Burguer", 18.50, "Pao, hamburguer, queijo e alface"));
        cardapio.add(new Lanche("X-Salada", 22.00, "Pao, hamburguer, queijo, alface, tomate e maionese"));
        cardapio.add(new Lanche("X-Tudo", 28.00, "Pao, 2 carnes, queijo, bacon, ovo, presunto"));

        cardapio.add(new Bebida("Coca-Cola", 7.00, 350));
        cardapio.add(new Bebida("Suco de Laranja", 8.50, 500));
        cardapio.add(new Bebida("Agua Mineral", 4.00, 500));
    }

    private static void exibirMenu() {
        System.out.println("---------- CARDAPIO ----------");
        for (int i = 0; i < cardapio.size(); i++) {
            Produto p = cardapio.get(i);
            System.out.printf("%d - %s (R$ %.2f)%n", i + 1, p.getNome(), p.getPreco());
        }
        System.out.println("0 - Finalizar pedido");
        System.out.println("------------------------------");
    }

    private static int lerInteiro(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.println("Digite um numero valido!");
            sc.next();
            System.out.print(msg);
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }
}
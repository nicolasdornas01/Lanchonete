import modelo.Bebida;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Lanche;
import modelo.Pedido;

public class Main {

    public static void main(String[] args) {

        // 1. Criando os produtos (cardápio)
        Lanche xBurguer = new Lanche(
                "X-Burguer",
                18.50,
                "Pão, hambúrguer, queijo e alface"
        );

        Lanche xSalada = new Lanche(
                "X-Salada",
                22.00,
                "Pão, hambúrguer, queijo, alface, tomate e maionese"
        );

        Bebida cocaCola = new Bebida(
                "Coca-Cola",
                7.00,
                350
        );

        // 2. Criando o cliente
        Cliente cliente = new Cliente(
                "Nicolas Pinheiro",
                "Rua das Flores, 123 - Belo Horizonte/MG"
        );

        // 3. Criando o pedido com taxa de entrega de R$ 8,00
        Pedido pedido = new Pedido(cliente, 8.00);

        // 4. Adicionando itens ao pedido
        pedido.adicionarItem(new ItemPedido(xBurguer, 2));   // 2x X-Burguer
        pedido.adicionarItem(new ItemPedido(xSalada, 1));    // 1x X-Salada
        pedido.adicionarItem(new ItemPedido(cocaCola, 2));   // 2x Coca-Cola

        // 5. Exibindo os produtos individualmente (mostra polimorfismo!)
        System.out.println("=== PRODUTOS DO CARDÁPIO ===");
        System.out.println(xBurguer.exibir());
        System.out.println(xSalada.exibir());
        System.out.println(cocaCola.exibir());
        System.out.println();

        // 6. Exibindo o resumo final do pedido
        pedido.exibirResumo();
    }
}
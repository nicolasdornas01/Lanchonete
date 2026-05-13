package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<ItemPedido> itens;
    private double taxaEntrega;

    public Pedido(Cliente cliente, double taxaEntrega) {
        this.cliente = cliente;
        this.taxaEntrega = taxaEntrega;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : itens) {
            subtotal += item.calcularSubtotal();
        }
        return subtotal;
    }

    public double calcularDesconto() {
        double subtotal = calcularSubtotal();
        if (subtotal > 50.0) {
            return subtotal * 0.10;
        }
        return 0;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDesconto() + taxaEntrega;
    }

    public void exibirResumo() {
        System.out.println("==========================================");
        System.out.println("           RESUMO DO PEDIDO");
        System.out.println("==========================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("------------------------------------------");
        System.out.println("Itens do pedido:");
        for (ItemPedido item : itens) {
            System.out.println(item.exibir());
        }
        System.out.println("------------------------------------------");
        System.out.printf("Subtotal:       R$ %.2f%n", calcularSubtotal());

        if (calcularDesconto() > 0) {
            System.out.printf("Desconto (10%%): R$ %.2f%n", calcularDesconto());
        }

        System.out.printf("Taxa entrega:   R$ %.2f%n", taxaEntrega);
        System.out.println("------------------------------------------");
        System.out.printf("TOTAL:          R$ %.2f%n", calcularTotal());
        System.out.println("==========================================");
    }

    // Getters e Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
    public void adicionarItem(Produto produto, int quantidade) {
        itens.add(new ItemPedido(produto, quantidade));
    }
}
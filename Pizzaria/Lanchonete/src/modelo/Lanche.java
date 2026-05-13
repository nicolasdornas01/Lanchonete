package modelo;

public class Lanche extends Produto {

    private String ingredientes;

    public Lanche(String nome, double preco, String ingredientes) {
        super(nome, preco);
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String exibir() {
        return String.format("🍔 Lanche: %s - R$ %.2f%n   Ingredientes: %s",
                getNome(), getPreco(), ingredientes);
    }
}
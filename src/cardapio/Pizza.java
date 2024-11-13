package cardapio;

public class Pizza extends ItemCardapio {
    public Pizza(String nome, double preco) {
        super(nome, preco);  // Chama o construtor da classe ItemCardapio
    }

    @Override
    public String toString() {
        return "Pizza: " + getNome() + ", Preço: R$ " + getPreco();
    }
}

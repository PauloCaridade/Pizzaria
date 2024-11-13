package cardapio;

public class Bebida extends ItemCardapio {
    public Bebida(String nome, double preco) {
        super(nome, preco);  // Chama o construtor da classe ItemCardapio
    }

    @Override
    public String toString() {
        return "Bebida: " + getNome() + ", Preço: R$ " + getPreco();
    }
}

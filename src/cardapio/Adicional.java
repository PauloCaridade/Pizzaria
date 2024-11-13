package cardapio;

public class Adicional extends ItemCardapio {
    public Adicional(String nome, double preco) {
        super(nome, preco);  // Chama o construtor da classe ItemCardapio
    }

    @Override
    public String toString() {
        return "Adicional: " + getNome() + ", Preço: R$ " + getPreco();
    }
}

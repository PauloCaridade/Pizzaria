package cardapio;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Pizza> pizzas;  // Lista de pizzas
    private List<Adicional> adicionais;  // Lista de adicionais
    private List<Bebida> bebidas;  // Lista de bebidas

    // Construtor que inicializa os itens do cardápio
    public Cardapio() {
        this.pizzas = new ArrayList<>();
        this.adicionais = new ArrayList<>();
        this.bebidas = new ArrayList<>();

        // Adicionar itens ao cardápio (exemplo)
        inicializarCardapio();
    }

    // Método para inicializar o cardápio com itens
    private void inicializarCardapio() {
        // Adicionando pizzas
        pizzas.add(new Pizza("Margherita", 25.0));
        pizzas.add(new Pizza("Calabresa", 30.0));
        pizzas.add(new Pizza("Quatro Queijos", 35.0));

        // Adicionando adicionais
        adicionais.add(new Adicional("Borda Recheada", 8.0));
        adicionais.add(new Adicional("Extra Queijo", 5.0));

        // Adicionando bebidas
        bebidas.add(new Bebida("Refrigerante", 6.0));
        bebidas.add(new Bebida("Suco de Laranja", 8.0));
        bebidas.add(new Bebida("Água Mineral", 3.0));
    }

    // Métodos para obter as listas de itens do cardápio
    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Adicional> getAdicionais() {
        return adicionais;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    // Exibe o cardápio completo
    public void exibirCardapio() {
        System.out.println("===== Cardápio =====");
        System.out.println("Pizzas:");
        for (Pizza pizza : pizzas) {
            System.out.println("- " + pizza.getNome() + " | Preço: R$ " + pizza.getPreco());
        }
        System.out.println("\nAdicionais:");
        for (Adicional adicional : adicionais) {
            System.out.println("- " + adicional.getNome() + " | Preço: R$ " + adicional.getPreco());
        }
        System.out.println("\nBebidas:");
        for (Bebida bebida : bebidas) {
            System.out.println("- " + bebida.getNome() + " | Preço: R$ " + bebida.getPreco());
        }
        System.out.println("====================");
    }
}

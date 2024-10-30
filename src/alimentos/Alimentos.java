package alimentos;

import java.util.List;

public class Alimentos {
    // Atributos
    private String nome;
    private double preco;
    private List<String> ingredientes;

    // Construtor
    public Alimentos(String nome, double preco, List<String> ingredientes) {
        this.nome = nome;
        this.preco = preco;
        this.ingredientes = ingredientes;
    }

    // Getters e Setters = Métodos para acessar e modificar os atributos.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    // Método para exibir informações do alimento
    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Ingredientes: " + String.join(", ", ingredientes));
    }
}

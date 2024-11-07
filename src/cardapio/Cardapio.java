package cardapio;

import excecoes.FormatoInvalidoException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<ItemCardapio> itens;

    public Cardapio() {
        this.itens = new ArrayList<>();
        inicializarCardapio();
    }

    private void inicializarCardapio() {
        itens.add(new Pizza("Margherita", 25.0));
        itens.add(new Pizza("Calabresa", 30.0));
        itens.add(new Pizza("Quatro Queijos", 35.0));

        itens.add(new Adicional("Borda Recheada", 8.0));
        itens.add(new Adicional("Extra Queijo", 5.0));

        itens.add(new Bebida("Refrigerante", 6.0));
        itens.add(new Bebida("Suco de Laranja", 8.0));
        itens.add(new Bebida("Água Mineral", 3.0));
    }

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public void exibirCardapio() {
        System.out.println("=============== Cardápio ==============");
        for (int i = 0; i < itens.size(); i++) {
            ItemCardapio item = itens.get(i);
            String tipo = item instanceof Pizza ? "Pizza" : item instanceof Adicional ? "Adicional" : "Bebida";
            System.out.println((i + 1) + ". " + tipo + " - " + item.getNome() + " | Preço: R$ " + item.getPreco());
        }
        System.out.println("======================================");
    }

    // Metodo para importar itens de um arquivo .txt
    public void importarItens(String filePath) throws FormatoInvalidoException {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(filePath));
            for (String linha : linhas) {
                String[] dados = linha.split(",");
                if (dados.length != 3) { // Verifica se há exatamente 3 elementos na linha
                    throw new FormatoInvalidoException("Formato inválido na linha: " + linha);
                }

                String tipo = dados[0].trim();
                String nome = dados[1].trim();
                double preco = Double.parseDouble(dados[2].trim());

                // Cria o item com base no tipo especificado
                switch (tipo.toLowerCase()) {
                    case "pizza":
                        itens.add(new Pizza(nome, preco));
                        break;
                    case "adicional":
                        itens.add(new Adicional(nome, preco));
                        break;
                    case "bebida":
                        itens.add(new Bebida(nome, preco));
                        break;
                    default:
                        throw new FormatoInvalidoException("Tipo de item desconhecido: " + tipo);
                }
            }
            System.out.println("Itens importados com sucesso.");
        } catch (FormatoInvalidoException e) {
            System.out.println("Erro de formatação: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo para exportar itens para um arquivo .txt
    public void exportarItens(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (ItemCardapio item : itens) {
                // Escreve o tipo do item, nome e preço no arquivo
                String tipo = item instanceof Pizza ? "Pizza" : item instanceof Adicional ? "Adicional" : "Bebida";
                writer.write(tipo + "," + item.getNome() + "," + item.getPreco());
                writer.newLine();
            }
            System.out.println("Itens exportados com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

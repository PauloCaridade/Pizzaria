package Pizzaria;

import cardapio.Cardapio;
import pedido.Pedido;
import pedido.ItemPedido;

public class Pizzaria {
    public static void main(String[] args) {
        // Inicializar o cardápio
        Cardapio cardapio = new Cardapio();
        cardapio.exibirCardapio();  // Exibe o cardápio completo

        // Criar um pedido (exemplo com dados de um cliente)
        Pedido pedido = new Pedido("123.456.789-00", "Lucas", "Rua A, 123", "99999-9999", "lucas@exemplo.com", "Delivery");

        // Selecionar itens do cardápio e adicionar ao pedido
        ItemPedido pizza1 = new ItemPedido("Margherita", 2, cardapio.getPizzas().get(0).getPreco(), null);
        pedido.adicionarItem(pizza1);

        ItemPedido bebida1 = new ItemPedido("Refrigerante", 1, cardapio.getBebidas().get(0).getPreco(), null);
        pedido.adicionarItem(bebida1);

        // Exibir os detalhes do pedido
        pedido.exibirDetalhesPedido();
    }
}

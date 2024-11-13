package interfaceGrafica;

import pedido.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaFuncionario extends JFrame {
    private JButton listaPedidosButton;
    private ArrayList<Pedido> pedidos;

    public TelaFuncionario(ArrayList<Pedido> pedidos) {

        this.pedidos = pedidos;
        setTitle("Tela Funcionário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centraliza a janela na tela


        listaPedidosButton = new JButton("Exibir Lista de Pedidos");

        // Adiciona um evento ao botão
        listaPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPedidos();
            }
        });

        // Configura o layout
        setLayout(new FlowLayout());
        add(listaPedidosButton);  // Adiciona o botão à tela
    }

    private void exibirPedidos() {
        System.out.println("\nVocê escolheu 'Lista de Pedidos'.");
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos no momento.");
        } else {
            System.out.println("============= Lista de Pedidos =============");
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println("Pedido " + (i + 1) + ":");
                pedidos.get(i).exibirDetalhesPedido();
                System.out.println("============================================");
            }
        }
    }

}

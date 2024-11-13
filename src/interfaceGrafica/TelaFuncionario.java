package interfaceGrafica;

import pedido.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TelaFuncionario extends JFrame {
    private JButton listaPedidosButton;
    private ArrayList<Pedido> pedidos;
    private boolean exibirPedidosChamado = false;

    public TelaFuncionario(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
        setTitle("Tela Funcionário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        listaPedidosButton = new JButton("Exibir Lista de Pedidos");

        // Adiciona um evento ao botão
        listaPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPedidos();
                exibirPedidosChamado = true;  // Marca que o botão foi pressionado
            }
        });

        setLayout(new FlowLayout());
        add(listaPedidosButton);
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

    public boolean isExibirPedidosChamado() {
        return exibirPedidosChamado;
    }
}

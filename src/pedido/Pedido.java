package pedido;

import pagamento.Pagamento;
import java.util.ArrayList;

public class Pedido {

    private String cpfCliente;
    private String nomeCliente;
    private String enderecoCliente;
    private String telefoneCliente;
    private String emailCliente;


    private final ArrayList<ItemPedido> itens;
    private String tipoEntrega;
    private double valorTotal;
    private Pagamento tipoPagamento;

    public Pedido(String cpf, String nome, String endereco, String telefone, String email, String tipoEntrega) {
        this.cpfCliente = cpf;
        this.nomeCliente = nome;
        this.enderecoCliente = endereco;
        this.telefoneCliente = telefone;
        this.emailCliente = email;
        this.tipoEntrega = tipoEntrega;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }


    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        this.valorTotal += item.calcularPrecoTotal();
    }


    public double calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.calcularPrecoTotal();
        }
        return valorTotal;
    }


    public void setTipoPagamento(Pagamento pagamento) {
        this.tipoPagamento = pagamento;
    }

    public Pagamento getTipoPagamento() {
        return this.tipoPagamento;
    }


    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }


    public void exibirDetalhesPedido() {
        System.out.println("Detalhes do Pedido:");
        System.out.println("Cliente: " + this.nomeCliente);
        System.out.println("CPF: " + this.cpfCliente);
        System.out.println("Endereço: " + this.enderecoCliente);
        System.out.println("Telefone: " + this.telefoneCliente);
        System.out.println("Email: " + this.emailCliente);
        System.out.println("Tipo de Entrega: " + this.tipoEntrega);
        System.out.println("Itens do Pedido:");


        for (ItemPedido item : itens) {
            System.out.println("- " + item.getNomeItem() + " | Qtd: " + item.getQuantidade() + " | Preço: R$" + item.calcularPrecoTotal());
        }


        System.out.println("Valor Total do Pedido: R$ " + this.calcularValorTotal());


        if (this.tipoPagamento != null) {
            System.out.println("Tipo de Pagamento: " + this.tipoPagamento.getClass().getSimpleName());
        } else {
            System.out.println("Tipo de Pagamento: Não definido");
        }
    }
}

package pagamento;

public class CartaoDebito extends Pagamento {

    private String titular;
    private String numero;
    private String validade;
    private String cvv;

    public CartaoDebito(double valor, String titular, String numero, String validade, String cvv) {
        super(valor);
        this.setTitular(titular);
        this.setNumero(numero);
        this.setValidade(validade);
        this.setCvv(cvv);
    }

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public void pagar() {
        super.setStatus("PAGO");
        System.out.println("Pago com cartão de debito.");
    }

    @Override
    public void cancelarPagamento() {
        super.setStatus("CANCELADO");
    }

    @Override
    public String statusPagamento() {
        return super.getStatus();
    }

    @Override
    public String getTipoPagamento() {
        return "Cartão de Debito";
    }

    public void exibirDadosCartaoDebito() {
        System.out.println("\nCartão de Debito" + "\n"+ "Titular: " + this.getTitular() + "\n" + "Numero: " + this.getNumero() + "\n"
                + "Validade: " + this.getValidade() + "\n" + "CVV: " + this.getCvv());
    }
}

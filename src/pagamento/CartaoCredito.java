package pagamento;

public class CartaoCredito extends Pagamento {

    private String titular;
    private String numero;
    private String validade;
    private String cvv;
    private double limite;

    public CartaoCredito(double valor, String titular, String numero, String validade, String cvv, double limite) {
        super(valor);
        this.setTitular(titular);
        this.setNumero(numero);
        this.setValidade(validade);
        this.setCvv(cvv);
        this.setLimite(limite);
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

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void pagar() {
        // logica do pagamento
        super.setStatus("PAGO");
    }

    @Override
    public void cancelarPagamento() {
        // logica do cancelamento
        super.setStatus("CANCELADO");
    }

    @Override
    public String statusPagamento() {
        return super.getStatus();
    }

}

package pagamento;

public abstract class Pagamento {

    private double valor;
    private String status;

    public Pagamento(double valor) {
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public double getValor() {
        return this.valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    abstract void pagar();
    abstract void cancelarPagamento();
    abstract String statusPagamento();

}

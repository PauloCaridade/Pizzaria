package pagamento;

public class Dinheiro extends Pagamento {

    public Dinheiro(double valor){
        super(valor);
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

package pagamento;

public class Dinheiro extends Pagamento {

    public Dinheiro(double valor){
        super(valor);
    }

    @Override
    public void pagar() {
        super.setStatus("PAGO");
        System.out.println("Pago com dinheiro.");
    }

    @Override
    public void cancelarPagamento() {
        super.setStatus("CANCELADO");
    }

    @Override
    public String getTipoPagamento() {
        return "Dinheiro";
    }

    @Override
    public String statusPagamento() {
        return super.getStatus();
    }

}

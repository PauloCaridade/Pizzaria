package pagamento;

public class Pix extends Pagamento {

    private String chavePix;
    private String instituicaoFinanceira;

    public Pix(double valor, String chavePix, String instituicaoFinanceira) {
        super(valor);
    }

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
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

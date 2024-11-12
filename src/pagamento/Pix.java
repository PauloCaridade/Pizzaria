package pagamento;
import pessoas.*;

public class Pix extends Pagamento {

    private String chavePix;
    private String instituicaoFinanceira;
    private String nomeProprietario;

    public Pix(double valor, String chavePix, String instituicaoFinanceira, Pessoa pessoa) {
        super(valor);
        this.setChavePix(chavePix);
        this.setInstituicaoFinanceira(instituicaoFinanceira);
        this.setNomeProprietario(pessoa.getNome());
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

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
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

    public void dadosPix() {
        System.out.println("\nChave Pix: " + chavePix + "\nInstituicao Financeira: " + instituicaoFinanceira);
    }
}

package pedido;

public class ItemPedido {
    private String nomeItem;
    private int quantidade;
    private double precoUnitario;
    private String adicionais;


    public ItemPedido(String nomeItem, int quantidade, double precoUnitario, String adicionais) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.adicionais = adicionais;
    }

    public ItemPedido(String nomeItem, int quantidade, double precoUnitario) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }


    // Método para calcular o preço total do item
    public double calcularPrecoTotal() {
        return this.quantidade * this.precoUnitario;
    }

    // Getters e Setters
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getAdicionais() {
        return adicionais;
    }

    public void setAdicionais(String adicionais) {
        this.adicionais = adicionais;
    }
}

package pessoas;

public abstract class Pessoa {

    private String nome;
    private int idade;
    private String genero;
    private String endereco;
    private String telefone;
    private String email;

    public Pessoa(String nome, int idade, String genero, String endereco, String telefone, String email) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setGenero(genero);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEmail(email);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n" + "Gênero: " + this.genero + "\n" +
                "Endereço: " + this.endereco + "\n" + "Telefone: " + this.telefone + "\n" + "E-mail: " + this.email + "\n";
    }

}

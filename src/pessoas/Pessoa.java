package pessoas;

public abstract class Pessoa {

    private String nome;
    private int idade;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    public Pessoa(String nome, int idade, String cpf, String endereco, String telefone, String email) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setCpf(cpf);
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

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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


    public String exibirInformacoes() {
        return "Nome: " + this.nome + "\n" + "Idade: " + this.idade + "\n" + "CPF: " + this.cpf + "\n" +
                "Endereço: " + this.endereco + "\n" + "Telefone: " + this.telefone + "\n" + "E-mail: " + this.email + "\n";
    }

    public void editarDados(String nome, int idade, String cpf, String endereco, String telefone, String email) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
        this.setEmail(email);
    }

}

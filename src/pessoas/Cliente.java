package pessoas;

public class Cliente extends Pessoa implements  AutenticarLogin {

    private String login;
    private String senha;

    public Cliente (String nome, int idade, String genero, String endereco, String telefone, String email, String login, String senha){
        super(nome, idade, genero, endereco, telefone, email);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    @Override
    public String exibirInformacoes() {
        return "Nome: " + super.getNome() + "\n" + "Idade: " + super.getIdade() + "\n" + "CPF: " + super.getCpf() + "\n" +
                "Endereço: " + super.getEndereco() + "\n" + "Telefone: " + super.getTelefone() + "\n" + "E-mail: " + super.getEmail() + "\n" +
                "Login:" + this.getLogin() + "\n" + "Senha: " + this.getSenha();
    }


}

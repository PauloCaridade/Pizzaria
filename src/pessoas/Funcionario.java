package pessoas;

import java.util.Random;

public class Funcionario extends Pessoa implements AutenticarLogin {

    private int idFuncionario;
    private String cargo;
    private double salario;
    private String login;
    private String senha;

    public Funcionario(String nome, int idade, String genero, String endereco, String telefone, String email,String cargo, double salario, String login, String senha) {
        super(nome, idade, genero, endereco, telefone, email);
        this.setIdFuncionario();
        this.setCargo(cargo);
        this.setSalario(salario);
        this.setLogin(login);
        this.setSenha(senha);
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    protected void setIdFuncionario() {
        Random r = new Random();
        this.idFuncionario = r.nextInt(10_000);
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
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
    public String toString() {
        return "\nNome: " + super.getNome() + "\n" + "Idade: " + super.getIdade() + "\n" + "Gênero: " + super.getGenero() + "\n" +
                "Endereço: " + super.getEndereco() + "\n" + "Telefone: " + super.getTelefone() + "\n" + "E-mail: "
                + super.getEmail() + "\n" + "Cargo: " + this.getCargo() + "\n" + "Salário: R$" + this.getSalario() +
                "\n" + "ID: " + this.getIdFuncionario();
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

}

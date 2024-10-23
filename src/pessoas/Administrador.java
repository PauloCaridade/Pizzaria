package pessoas;

import java.util.ArrayList;

public class Administrador extends Funcionario  implements Administar{

    private String login;
    private String senha;

   public Administrador(String nome, int idade, String genero, String endereco, String telefone, String email, String login, String senha) {
       super(nome, idade, genero, endereco, telefone, email, "admin",7.500,login,senha);
       super.setIdFuncionario();
   }


    @Override
    public void adicionarFuncionario(Funcionario f, ArrayList<Funcionario> funcionarios) {
       funcionarios.add(f);
    }

    @Override
    public void excluirFuncionario(Funcionario f, ArrayList<Funcionario> funcionarios) {
       for(Funcionario funcionario : funcionarios){
           if(funcionario.getIdFuncionario() == f.getIdFuncionario()){
               funcionarios.remove(funcionario);
           }
           else {
               System.out.println("Funcionário não encontrado");
           }
       }
    }

    @Override
    public void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
        for(Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }


}

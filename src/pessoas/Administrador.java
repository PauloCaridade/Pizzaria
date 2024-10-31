package pessoas;

import java.util.ArrayList;

public class Administrador extends Funcionario  implements Administar{

    private String login;
    private String senha;

   public Administrador(String nome, int idade, String genero, String endereco, String telefone, String email, String login, String senha) {
       super(nome, idade, genero, endereco, telefone, email, "admin",7500,login,senha);
       super.setIdFuncionario();
   }


    @Override
    public void adicionarFuncionario(Funcionario f, ArrayList<Funcionario> funcionarios) {

       funcionarios.add(f);

       System.out.println("Funcionario " + f.getNome() + " adicionado com sucesso!");
    }

    @Override
    public void excluirFuncionario(Funcionario f, ArrayList<Funcionario> funcionarios) {
       for(int i = 0; i < funcionarios.size(); i++){
           Funcionario fun = funcionarios.get(i);
           if(fun.getIdFuncionario() == f.getIdFuncionario()){
               funcionarios.remove(i);
               System.out.println("Funcionario " + f.getNome() + " excluido com sucesso!");
               break;
           }
       }
    }

    @Override
    public void listarFuncionarios(ArrayList<Funcionario> funcionarios) {
       System.out.println("Lista de funcionários");
        for(Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
            System.out.println();
        }
    }


}

package pessoas;

import java.util.ArrayList;

public class Administrador extends Funcionario  implements Administar{

    private String login;
    private String senha;

   public Administrador(String nome, int idade, String cpf, String endereco, String telefone, String email, String login, String senha) {
       super(nome, idade, cpf, endereco, telefone, email, "admin",7500,login,senha);
       super.setIdFuncionario();
   }


    @Override
    public void adicionarFuncionario(Pessoa p, ArrayList<Pessoa> pessoas) {

       pessoas.add(p);

       System.out.println("Funcionario " + p.getNome() + " adicionado com sucesso!");
    }

    @Override
    public void excluirFuncionario(Pessoa p, ArrayList<Pessoa> pessoas) {
       Pessoa funcionarioSelecionado = null;
       // verifica se a pessoa fornecida é um funcionário
       if(p instanceof Funcionario f && !(p instanceof Administrador) && !(p instanceof Cliente)) {

           for(Pessoa pessoa : pessoas) {
               // verifica na lista de pessoas se existem algum funcionário com o mesmo ID
               if(pessoa instanceof Funcionario fa && !(pessoa instanceof Administrador) && !(pessoa instanceof Cliente)){
                   // verifica se os ID's são iguais
                   if(fa.getIdFuncionario() == f.getIdFuncionario()) {
                       funcionarioSelecionado = pessoa;
                   }
               }
           }
       }
       if(funcionarioSelecionado == null) {
           System.out.println("\nFuncionário não encontrado.");
       }
       else{
           pessoas.remove(funcionarioSelecionado);
           System.out.println("\nFuncionário removido com sucesso.");
       }
    }


    @Override
    public void listarFuncionarios(ArrayList<Pessoa> pessoas) {
       int cont = 0;
        for(Pessoa p: pessoas) {
            if(!(p instanceof Administrador) && !(p instanceof Cliente) && p != null){
                Funcionario f = (Funcionario) p;
                System.out.println(f);
                cont++;
            }
        }
        if(cont == 0) {
            System.out.println("\nNão há funcionários cadastrados.");
        }
    }


}

package Pizzaria;
import java.util.ArrayList;
import java.util.Scanner;
import pessoas.*;


public class Pizzaria {

    public static void main(String[] args) {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();


        pessoas.add(new Cliente("João Vitor",22,"Masculino","Curitiba",
                "998655302","joão@gmail.com","joãov","joão123"));

        pessoas.add(new Funcionario("Leonardo",25,"Masculino","Curitiba",
        "114255807","leo@outlook.com","Pizzaiolo",2500,"leleco","leo123"));

        pessoas.add(new Administrador("Pedro",35,"Masculino","Curitiba",
            "556382970","pedro@gmail.com","pedro","123"));


        Scanner input = new Scanner(System.in);
        Pessoa usuarioLogado = null;


        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      Tela de Login do Sistema    ║");
        System.out.println("╚══════════════════════════════════╝");

        while(usuarioLogado == null){
            System.out.print("╔═ Usuário: ");
            String usuario = input.nextLine();

            System.out.print("╠═ Senha: ");
            String senha = input.nextLine();
            System.out.println("╚═════════════════════════════");

            usuarioLogado = autenticarUsuario(pessoas, usuario, senha);

            if (usuarioLogado == null) {
                System.out.println("Usuário ou senha incorretos. Tente novamente.");
            }

            if(usuarioLogado instanceof Administrador a){

                System.out.printf("Login bem sucedido!\nOlá, %s.",usuarioLogado.getNome());
                boolean sair = false;

                while (!sair){
                    System.out.println("\n╔═════════════════════════════╗");
                    System.out.println("║        Administrador        ║");
                    System.out.println("╠═════════════════════════════╣");
                    System.out.println("║ 1. Adicionar Funcionário    ║");
                    System.out.println("║ 2. Excluir Funcionário      ║");
                    System.out.println("║ 3. Listar Funcionários      ║");
                    System.out.println("║ 4. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");
                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            System.out.print("Nome: ");
                            String nomeFuncionario = input.nextLine();
                            System.out.print("Idade: ");
                            int idadeFuncionario = input.nextInt();
                            input.nextLine();
                            System.out.print("Genero: ");
                            String generoFuncionario = input.nextLine();
                            System.out.print("Endereço: ");
                            String enderecoFuncionario = input.nextLine();
                            System.out.print("Telefone: ");
                            String telefoneFuncionario = input.nextLine();
                            System.out.print("E-mail: ");
                            String emailFuncionario = input.nextLine();
                            System.out.print("Cargo: ");
                            String cargoFuncionario = input.nextLine();
                            System.out.print("Salário: ");
                            double salarioFuncionario = input.nextDouble();
                            input.nextLine();
                            System.out.print("Login: ");
                            String loginFuncionario = input.nextLine();
                            System.out.print("Senha: ");
                            String senhaFuncionario = input.nextLine();
                            Funcionario novoFuncionario = new Funcionario(nomeFuncionario,idadeFuncionario,
                                    generoFuncionario,enderecoFuncionario,telefoneFuncionario,emailFuncionario,
                                    cargoFuncionario,salarioFuncionario,loginFuncionario,senhaFuncionario);
                            pessoas.add(novoFuncionario);
                            break;
                        case "2":
                            a.listarFuncionarios(pessoas);
                            System.out.print("Selecione o funcionário (nome) para exclusão: ");
                            String funcionarioVerificado = input.nextLine();
                            Pessoa funcinarioSelecionado = null;
                            for(Pessoa pessoa : pessoas){
                                if(pessoa instanceof Funcionario f && !(pessoa instanceof Administrador) && !(pessoa instanceof Cliente)){
                                    if(funcionarioVerificado.toLowerCase().equals(pessoa.getNome().toLowerCase())){
                                        funcinarioSelecionado = pessoa;
                                    }
                                }
                            }
                            a.excluirFuncionario(funcinarioSelecionado,pessoas);
                            break;
                        case "3":
                            a.listarFuncionarios(pessoas);
                            break;
                        case "4":
                            System.out.println("\nSaindo do sistema. Até mais!");
                            sair = true;
                            break;
                        default:
                            System.out.println("\n⚠️ Opção inválida. Tente novamente.");
                            break;
                    }
                }

            }

            else if (usuarioLogado instanceof Cliente) {

                System.out.printf("Login bem sucedido!\nOlá, %s.",usuarioLogado.getNome());
                boolean sair = false;

                while (!sair){

                    System.out.println("\n╔═════════════════════════════╗");
                    System.out.println("║        MENU PRINCIPAL       ║");
                    System.out.println("╠═════════════════════════════╣");
                    System.out.println("║ 1. Fazer Pedido             ║");
                    System.out.println("║ 2. Visualizar Cardápio      ║");
                    System.out.println("║ 3. Gerenciar Conta          ║");
                    System.out.println("║ 4. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            System.out.println("\nVocê escolheu 'Fazer Pedido'.");
                            break;
                        case "2":
                            System.out.println("\nVocê escolheu 'Visualizar Cardápio'.");
                            break;
                        case "3":
                            System.out.println("\nVocê escolheu 'Gerenciar Conta'.");
                            break;
                        case "4":
                            System.out.println("\nSaindo do sistema. Até mais!");
                            sair = true;
                            break;
                        default:
                            System.out.println("\n⚠️ Opção inválida. Tente novamente.");
                            break;
                    }
                }

            } else if (usuarioLogado instanceof Funcionario) {

                System.out.printf("Login bem sucedido!\nOlá, %s.",usuarioLogado.getNome());
                boolean sair = false;

                while (!sair){
                    System.out.println("\n╔═════════════════════════════╗");
                    System.out.println("║         Funcionário         ║");
                    System.out.println("╠═════════════════════════════╣");
                    System.out.println("║ 1. Cadastrar Produtos       ║");
                    System.out.println("║ 2. Lista de Pedidos         ║");
                    System.out.println("║ 3. Lista de Alimentos       ║");
                    System.out.println("║ 4. Imprimir Pedidos         ║");
                    System.out.println("║ 5. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    // Captura da escolha do usuário
                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            System.out.println("\nVocê escolheu 'Fazer Pedido'.");
                            // Adicione a lógica para fazer um pedido aqui
                            break;
                        case "2":
                            System.out.println("\nVocê escolheu 'Visualizar Cardápio'.");
                            // Adicione a lógica para visualizar o cardápio aqui
                            break;
                        case "3":
                            System.out.println("\nVocê escolheu 'Gerenciar Conta'.");
                            // Adicione a lógica para gerenciar a conta aqui
                            break;
                        case "4":
                            // adicionar lógica para imprimir pedidos
                            break;
                        case "5":
                            System.out.println("\nSaindo do sistema. Até mais!");
                            sair = true;
                            break;
                        default:
                            System.out.println("\n⚠️ Opção inválida. Tente novamente.");
                            break;
                    }
                }
            }

        }

        input.close();
    }

    private static Pessoa autenticarUsuario(ArrayList<Pessoa> pessoas, String login, String senha){
        for(Pessoa p : pessoas){
            if(p instanceof AutenticarLogin a){
                if(a.autenticar(login,senha)){
                 return p;
                }
            }
        }
        return null; // retorna null caso o login tenha falhado
    }


}

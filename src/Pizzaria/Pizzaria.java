package Pizzaria;
import java.util.ArrayList;
import java.util.Scanner;
import pessoas.*;
import pedido.*;
import cardapio.*;


public class Pizzaria {

    public static void main(String[] args) {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        Cardapio cardapio = new Cardapio();  // Cria o cardápio
        ArrayList<Pedido> pedidos = new ArrayList<>();  // Lista para armazenar pedidos


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
                            System.out.print("CPF: ");
                            String cpfFuncionario = input.nextLine();
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
                                    cpfFuncionario,enderecoFuncionario,telefoneFuncionario,emailFuncionario,
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

            else if (usuarioLogado instanceof Cliente c) {

                System.out.printf("Login bem sucedido!\nOlá, %s.",usuarioLogado.getNome());
                boolean sair = false;

                while (!sair){

                    System.out.println("\n╔═════════════════════════════╗");
                    System.out.println("║        MENU PRINCIPAL       ║");
                    System.out.println("╠═════════════════════════════╣");
                    System.out.println("║ 1. Fazer Pedido             ║");
                    System.out.println("║ 2. Visualizar Cardápio      ║");
                    System.out.println("║ 3. Alterar Dados            ║");
                    System.out.println("║ 4. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            realizarPedido(input,c,cardapio,pedidos);
                            break;
                        case "2":
                            cardapio.exibirCardapio();
                            break;
                        case "3":
                                System.out.print("Nome: ");
                                String novoNome = input.nextLine();
                                System.out.print("Idade: ");
                                int novaIdade = input.nextInt();
                                input.nextLine();
                                System.out.print("CPF: ");
                                String novoCpf = input.nextLine();
                                System.out.print("Endereço: ");
                                String novoEndereco = input.nextLine();
                                System.out.print("Telefone: ");
                                String novoTelefone = input.nextLine();
                                System.out.print("Email: ");
                                String novoEmail = input.nextLine();
                                c.editarDados(novoNome,novaIdade,novoCpf,novoEndereco,novoTelefone,novoEmail);
                                System.out.print(c);
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

    private static void realizarPedido(Scanner scanner, Cliente cliente, Cardapio cardapio, ArrayList<Pedido> pedidos){
        Pedido pedido = new Pedido(cliente.getCpf(),cliente.getNome(),cliente.getEndereco(),cliente.getTelefone(),
                cliente.getEmail(),"definir");
        boolean pedidoFinalizado = false;
        String continuarPedido;
        int categoriaAlimento;

        while(!pedidoFinalizado){

            System.out.println();
            cardapio.exibirCardapio();
            System.out.print("Escolha uma categoria\n1-Pizza\n2-Adicional\n3-Bebida\nCategoria: ");
            categoriaAlimento= scanner.nextInt();
            scanner.nextLine();

            if(categoriaAlimento == 1){
                int pizzaEscolhida;
                System.out.println();
                for(int i = 0; i < cardapio.getPizzas().size(); i++){
                    System.out.println((i + 1) + ") " + cardapio.getPizzas().get(i).getNome() +
                            " | Preço: R$ " + cardapio.getPizzas().get(i).getPreco());
                }
                System.out.print("Escolha a pizza: ");
                pizzaEscolhida = scanner.nextInt();

                if( pizzaEscolhida  >= 1 && pizzaEscolhida <= cardapio.getPizzas().size()){
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    ItemPedido itemPedidoPizza = new ItemPedido(cardapio.getPizzas().get(pizzaEscolhida - 1).getNome(), quantidade,
                            cardapio.getPizzas().get(pizzaEscolhida - 1).getPreco());
                    pedido.adicionarItem(itemPedidoPizza);
                    System.out.println("\nPizza "+cardapio.getPizzas().get(pizzaEscolhida - 1).getNome() +
                            " Adicionada aos pedidos!");
                    pedidos.add(pedido);

                    System.out.print("\nDeseja realizar mais algum pedido?[S/N]\n\nOpção:");
                    continuarPedido = scanner.nextLine();
                    if(continuarPedido.toLowerCase().equals("n")){
                        for(Pedido p : pedidos){
                            if(p.getCpfCliente() == cliente.getCpf()){
                                p.exibirDetalhesPedido();
                            }
                        }
                        pedidoFinalizado = true;
                    }

                }

            }
            else if(categoriaAlimento == 2){
                System.out.println("você escolheu bebida!");
            }
            else if(categoriaAlimento == 3){
                System.out.println("você escolheu um adicional!");
            }
        }
    }


}

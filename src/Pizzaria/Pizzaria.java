package Pizzaria;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import pessoas.*;
import pedido.*;
import cardapio.*;
import excecoes.FormatoInvalidoException;

public class Pizzaria {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Cardapio cardapio = new Cardapio();  // Cria o cardápio
        ArrayList<Pedido> pedidos = new ArrayList<>();  // Lista para armazenar pedidos

        // Exemplo de clientes e funcionários
        //pessoas.add(new Cliente("João Vitor",22,"Masculino","Curitiba",
                //"998655302","joão@gmail.com","joãov","joão123"));

        Pessoa p1 = new Cliente("João Vitor",22,"Masculino","Curitiba",
                "998655302","joão@gmail.com","joãov","joão123");

        // Salvando o objeto pessoa (isso irá salvar no seu disco)
        salvarPessoa(p1);

        // Carregando a pessoa que salvamos (aqui carregamos do disco)
        Pessoa p2 = carregarPessoa();

        // Imprimindo informações da pessoa que foi carregada do arquivo 'pessoa.txt'
        System.out.println(p2.exibirInformacoes());

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
                    System.out.println("║ 4. Importar Cardápio        ║");
                    System.out.println("║ 5. Exportar Cardápio        ║");
                    System.out.println("║ 6. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");
                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            // Código para adicionar funcionário
                            break;
                        case "2":
                            // Código para excluir funcionário
                            break;
                        case "3":
                            // Código para listar funcionários
                            break;
                        case "4":
                            System.out.print("Digite o caminho do arquivo para importação: ");
                            String caminhoImportar = input.nextLine();
                            try {
                                cardapio.importarItens(caminhoImportar);
                            } catch (FormatoInvalidoException e) {
                                System.out.println("Erro ao importar: " + e.getMessage());
                            }
                            break;
                        case "5":
                            System.out.print("Digite o caminho do arquivo para exportação: ");
                            String caminhoExportar = input.nextLine();
                            cardapio.exportarItens(caminhoExportar);
                            break;
                        case "6":
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
                            realizarPedido(input, c, cardapio, pedidos);
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
                            c.editarDados(novoNome, novaIdade, novoCpf, novoEndereco, novoTelefone, novoEmail);
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
                    System.out.println("║ 3. Imprimir Pedidos         ║");
                    System.out.println("║ 4. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            System.out.println("\nVocê escolheu 'Cadastrar Produtos'.");
                            // Adicione a lógica para cadastro de produtos aqui
                            break;
                        case "2":
                            System.out.println("\nVocê escolheu 'Lista de Pedidos'.");
                            // Adicione a lógica para listar pedidos aqui
                            break;
                        case "3":
                            System.out.println("\nVocê escolheu 'Imprimir Pedidos'.");
                            // Adicione a lógica para imprimir pedidos aqui
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
        return null;
    }

    private static void realizarPedido(Scanner scanner, Cliente cliente, Cardapio cardapio, ArrayList<Pedido> pedidos){
        Pedido pedido = new Pedido(cliente.getCpf(), cliente.getNome(), cliente.getEndereco(), cliente.getTelefone(),
                cliente.getEmail(),"definir");
        boolean pedidoFinalizado = false;

        while(!pedidoFinalizado){
            System.out.println();
            cardapio.exibirCardapio();
            System.out.print("Escolha um item pelo número ou 'S' para sair: ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("S")) {
                pedidoFinalizado = true;
            } else {
                try {
                    int itemIndex = Integer.parseInt(escolha) - 1;
                    ItemCardapio item = cardapio.getItens().get(itemIndex);
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();
                    ItemPedido itemPedido = new ItemPedido(item.getNome(), quantidade, item.getPreco());
                    pedido.adicionarItem(itemPedido);
                    System.out.println("Item " + item.getNome() + " adicionado ao pedido!");
                } catch (Exception e) {
                    System.out.println("Seleção inválida. Tente novamente.");
                }
            }
        }
        pedidos.add(pedido);
    }

    public static void salvarPessoa(Pessoa p) throws IOException {
        // Criamos um objeto que irá especificar o arquivo onde o objeto 'p'
        // será salvo. A extensão do arquivo não precisa ser necessariamente '.p'.
        // Eu poderia colocar qualquer extensão.
        FileOutputStream fos = new FileOutputStream("pessoa.txt");

        // Aqui criamos um outro objeto que é responsável por converter nosso
        // objeto 'p' em um formato que pode ser reconstruído posteriormente
        ObjectOutputStream os = new ObjectOutputStream(fos);

        // Escreve o objeto 'p' no arquivo
        os.writeObject(p);

        // Fecha o objeto de serialização
        os.close();

        // Fechamos o arquivo
        fos.close();
    }

    public static Pessoa carregarPessoa() throws IOException, ClassNotFoundException {
        // Criamos um objeto que irá especificar o arquivo onde está salvo um objeto.
        FileInputStream fis = new FileInputStream("pessoa.txt");

        // Aqui criamos um objeto que irá reconstruir o objeto armazenado no
        // 'fis' criado anteriormente
        ObjectInputStream is = new ObjectInputStream(fis);

        // Lemos o objeto e convertemos ele do arquivo 'pessoa.txt'. Na sequência nós
        // convertemos o objeto para o tipo 'Pessoa'
        Pessoa p = (Pessoa) is.readObject();

        // Fechamos o objeto de serialização
        is.close();

        // Fechamos o arquivo
        fis.close();
        return p;
    }
}

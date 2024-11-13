package Pizzaria;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import pessoas.*;
import pagamento.*;
import pedido.*;
import cardapio.*;
import excecoes.FormatoInvalidoException;

public class Pizzaria {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Cardapio cardapio = new Cardapio();
        ArrayList<Pedido> pedidos = new ArrayList<>();

        Pessoa p1 = new Cliente("João Vitor",22,"111.111.111-00","Curitiba",
                "(41) 998655302","joão@gmail.com","joãov","joão123");

        salvarPessoa(p1);
        Pessoa c1 = carregarPessoa();


        Pessoa c2 = new Cliente("Carlos Mendes", 40, "222.222.222-00", "Rua do Sol, 789",
                "(41) 98765-1234", "carlos.mendes@email.com", "carlosm", "carlos789");

        Pessoa c3 = new Cliente("Maria Oliveira", 25, "Feminino", "Avenida Central, 456",
                "(41) 91234-5678", "maria.oliveira@email.com", "marimari", "oliveira123");


        Pessoa fun = new Funcionario("Henrique Ancelotti",30,"333.333.333-00","Rua do Batel, 123",
                "(41) 98765-4321","henr@gmail.com","pizzaiolo",2500,"ancel","h123");


        Pessoa adm = new Administrador("Luiza Angela",40,"987.654.321-00","Avenida Central, 500",
                "(41) 12345-6789","lu@outlook.com","lulu","luangela111");

        pessoas.add(c1);
        pessoas.add(c2);
        pessoas.add(c3);
        pessoas.add(fun);
        pessoas.add(adm);


        Scanner input = new Scanner(System.in);
        Pessoa usuarioLogado = null;
        boolean sistemaAtivo = true;

        while(sistemaAtivo){
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
                            usuarioLogado = null;
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
                    System.out.println("║ 4. Métodos de Pagamento     ║");
                    System.out.println("║ 5. Realizar Pagamento       ║");
                    System.out.println("║ 6. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            Pedido novoPedido = criarPedido(input, c, cardapio);
                            pedidos.add(novoPedido);
                            System.out.println("Pedido realizado com sucesso!");
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
                            if (c.getMetodosPagamento().isEmpty()) {
                                System.out.println("\nCadastrar método de pagamento:");
                                cadastrarMetodoPagamento(input, c, c.getMetodosPagamento());
                            } else {
                                System.out.println("\nMétodos de pagamento já cadastrados:");
                                for (Pagamento m : c.getMetodosPagamento()) {
                                    if (m instanceof CartaoCredito cc) {
                                        cc.exibirDadosCartaoCredito();
                                    } else if (m instanceof CartaoDebito cd) {
                                        cd.exibirDadosCartaoDebito();
                                    } else if (m instanceof Pix pix) {
                                        pix.dadosPix();
                                    }
                                }
                                System.out.print("\nDeseja cadastrar um novo método de pagamento? (S/N): ");
                                String resposta = input.nextLine();
                                if (resposta.equalsIgnoreCase("s")) {
                                    cadastrarMetodoPagamento(input, c, c.getMetodosPagamento());
                                }
                            }
                            break;
                        case "5":
                            if (pedidos.isEmpty()) {
                                System.out.println("\nNão há pedidos pendentes para pagamento.");
                            } else {
                                System.out.println("\nPedidos Pendentes:");
                                for (int i = 0; i < pedidos.size(); i++) {
                                    System.out.printf("%d - Pedido de %s (R$ %.2f)\n", i + 1,
                                            pedidos.get(i).getNomeCliente(), pedidos.get(i).calcularValorTotal());
                                }
                                System.out.print("Escolha o pedido a ser pago: ");
                                int indicePedido = input.nextInt() - 1;
                                input.nextLine();

                                if (indicePedido >= 0 && indicePedido < pedidos.size()) {
                                    Pedido pedidoSelecionado = pedidos.get(indicePedido);

                                    if (c.getMetodosPagamento().isEmpty()) {
                                        System.out.println("Não há métodos de pagamento cadastrados.");
                                    } else {
                                        System.out.println("\nMétodos de Pagamento Disponíveis:");
                                        for (int i = 0; i < c.getMetodosPagamento().size(); i++) {
                                            System.out.printf("%d - %s (R$ %.2f)\n", i + 1,
                                                    c.getMetodosPagamento().get(i).getClass().getSimpleName(),
                                                    c.getMetodosPagamento().get(i).getValor());
                                        }
                                        System.out.print("Escolha o método de pagamento: ");
                                        int indiceMetodo = input.nextInt() - 1;
                                        input.nextLine();

                                        if (indiceMetodo >= 0 && indiceMetodo < c.getMetodosPagamento().size()) {
                                            Pagamento pagamento = c.getMetodosPagamento().get(indiceMetodo);
                                            pedidoSelecionado.setTipoPagamento(pagamento);
                                            if(pagamento instanceof CartaoCredito cc){
                                                cc.pagar();
                                            }
                                            else if(pagamento instanceof CartaoDebito cd){
                                                cd.pagar();
                                            }
                                            else if(pagamento instanceof Pix pix){
                                                pix.pagar();
                                            }
                                            else if (pagamento instanceof Dinheiro d) {
                                                d.pagar();
                                            }

                                            System.out.println("Pagamento realizado com sucesso!");
                                            pedidos.remove(indicePedido);
                                        } else {
                                            System.out.println("Método de pagamento inválido.");
                                        }
                                    }
                                } else {
                                    System.out.println("Pedido inválido.");
                                }
                            }
                            break;
                        case "6":
                            System.out.println("\nSaindo do sistema. Até mais!");
                            sair = true;
                            usuarioLogado = null;
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
                    System.out.println("║ 2. Alterar Produtos         ║");
                    System.out.println("║ 3. Lista de Pedidos         ║");
                    System.out.println("║ 4. Sair                     ║");
                    System.out.println("╚═════════════════════════════╝");
                    System.out.print("Escolha uma opção: ");

                    String escolha = input.nextLine();

                    switch (escolha) {
                        case "1":
                            System.out.println("\nVocê escolheu 'Cadastrar Produtos'.");
                            System.out.print("Escolha o tipo de produto:\n1 - Pizza\n2 - Bebida\n3 - Adicional\nOpção: ");
                            int tipoProduto = input.nextInt();
                            input.nextLine();  // Consome a nova linha

                            String nomeProduto;
                            double precoProduto;
                            switch (tipoProduto) {
                                case 1:  // Cadastrar Pizza
                                    System.out.print("Nome da Pizza: ");
                                    nomeProduto = input.nextLine();
                                    System.out.print("Preço da Pizza: R$ ");
                                    precoProduto = input.nextDouble();
                                    input.nextLine();

                                    // Cria um novo objeto Pizza e adiciona ao cardápio
                                    Pizza novaPizza = new Pizza(nomeProduto, precoProduto);
                                    cardapio.adicionarItem(novaPizza);
                                    System.out.println("Pizza cadastrada com sucesso!");
                                    cardapio.exibirItensComIndices();
                                    break;

                                case 2:  // Cadastrar Bebida
                                    System.out.print("Nome da Bebida: ");
                                    nomeProduto = input.nextLine();
                                    System.out.print("Preço da Bebida: R$ ");
                                    precoProduto = input.nextDouble();
                                    input.nextLine();

                                    // Cria um novo objeto Bebida e adiciona ao cardápio
                                    Bebida novaBebida = new Bebida(nomeProduto, precoProduto);
                                    cardapio.adicionarItem(novaBebida);
                                    System.out.println("Bebida cadastrada com sucesso!");
                                    cardapio.exibirItensComIndices();
                                    break;

                                case 3:  // Cadastrar Adicional
                                    System.out.print("Nome do Adicional: ");
                                    nomeProduto = input.nextLine();
                                    System.out.print("Preço do Adicional: R$ ");
                                    precoProduto = input.nextDouble();
                                    input.nextLine();

                                    // Cria um novo objeto Adicional e adiciona ao cardápio
                                    Adicional novoAdicional = new Adicional(nomeProduto, precoProduto);
                                    cardapio.adicionarItem(novoAdicional);
                                    System.out.println("Adicional cadastrado com sucesso!");
                                    cardapio.exibirItensComIndices();
                                    break;

                                default:
                                    System.out.println("Opção inválida.");
                                    break;
                            }
                            break;
                        case "2":
                            System.out.println("\nVocê escolheu 'Alterar Produtos'.");
                            if (cardapio.getItens().isEmpty()) {
                                System.out.println("O cardápio está vazio. Nenhum produto para alterar.");
                                break;
                            }

                            // Exibe os itens do cardápio com índices usando o metodo da classe Cardapio
                            cardapio.exibirItensComIndices();

                            // Solicita ao funcionário que escolha o produto para alteração
                            System.out.print("Escolha o número do produto que deseja alterar: ");
                            int produtoEscolhido = input.nextInt();
                            input.nextLine(); // Consumir a quebra de linha

                            // Verifica se a escolha é válida
                            if (produtoEscolhido < 1 || produtoEscolhido > cardapio.getItens().size()) {
                                System.out.println("Opção inválida.");
                                break;
                            }

                            // Obtém o item selecionado
                            ItemCardapio itemParaAlterar = cardapio.getItens().get(produtoEscolhido - 1);

                            // Solicita as novas informações
                            System.out.print("Novo nome para o produto (deixe em branco para não alterar): ");
                            String novoNome = input.nextLine();
                            if (!novoNome.isEmpty()) {
                                itemParaAlterar.setNome(novoNome);
                            }

                            System.out.print("Novo preço para o produto (digite 0 para não alterar): ");
                            double novoPreco = input.nextDouble();
                            input.nextLine();  // Consumir a quebra de linha
                            if (novoPreco > 0) {
                                itemParaAlterar.setPreco(novoPreco);
                            }

                            System.out.println("Produto alterado com sucesso!");
                            cardapio.exibirItensComIndices();
                            break;
                        case "3":
                            System.out.println("\nVocê escolheu 'Lista de Pedidos'.");

                            // Verifica se há pedidos na lista
                            if (pedidos.isEmpty()) {
                                System.out.println("Não há pedidos no momento.");
                            } else {
                                System.out.println("============= Lista de Pedidos =============");
                                // Exibe os detalhes de cada pedido
                                for (int i = 0; i < pedidos.size(); i++) {
                                    System.out.println("Pedido " + (i + 1) + ":");
                                    pedidos.get(i).exibirDetalhesPedido();
                                    System.out.println("============================================");
                                }
                            }
                            break;
                        case "4":
                            System.out.println("\nSaindo do sistema. Até mais!");
                            sair = true;
                            usuarioLogado = null;
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

    private static Pedido criarPedido(Scanner input, Cliente c, Cardapio cardapio) {
        System.out.println("\nIniciando um novo pedido...");
        System.out.print("Escolha o tipo de entrega (Retirar ou Entregar): ");
        String tipoEntrega = input.nextLine();

        Pedido novoPedido = new Pedido(c.getCpf(), c.getNome(), c.getEndereco(), c.getTelefone(), c.getEmail(), tipoEntrega);

        boolean adicionarMaisItens = true;
        while (adicionarMaisItens) {
            System.out.println("\nCardápio:");
            cardapio.exibirCardapio();

            System.out.print("Digite o número do item que deseja adicionar: ");
            int indiceItem = input.nextInt() - 1;
            input.nextLine();


            ItemCardapio itemEscolhido = cardapio.getItem(indiceItem);

            if (itemEscolhido != null) {
                System.out.print("Quantidade: ");
                int quantidade = input.nextInt();
                input.nextLine();

                System.out.print("Adicionais (se houver): ");
                String adicionais = input.nextLine();

                novoPedido.adicionarItem(itemEscolhido.getNome(), quantidade, itemEscolhido.getPreco(), adicionais);
                System.out.println("Item adicionado: " + itemEscolhido.getNome());
            } else {
                System.out.println("Item inválido. Tente novamente.");
            }

            System.out.print("Deseja adicionar mais itens? (S/N): ");
            String resposta = input.nextLine();
            adicionarMaisItens = resposta.equalsIgnoreCase("S");
        }

        return novoPedido;
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

    private static void cadastrarMetodoPagamento(Scanner input, Cliente c, ArrayList<Pagamento> metodosPagamento) {
        Pagamento pagamento;
        System.out.print("1 - Cartão de Crédito\n2 - Cartão de Débito\n3 - Pix\nMétodo: ");
        int metodo = input.nextInt();
        input.nextLine();

        switch (metodo) {
            case 1:
                System.out.print("\nTitular: " + c.getNome() + "\n");
                System.out.print("Número: ");
                String numero = input.nextLine();
                if (numero.length() < 16) {
                    System.out.println("Número inválido.");
                    return;
                }
                System.out.print("Validade (MM/AA): ");
                String validade = input.nextLine();
                System.out.print("CVV: ");
                String cvv = input.nextLine();
                pagamento = new CartaoCredito(0, c.getNome(), numero, validade, cvv);
                metodosPagamento.add(pagamento);
                break;
            case 2:
                System.out.print("\nTitular: " + c.getNome() + "\n");
                System.out.print("Número: ");
                String numeroDebito = input.nextLine();
                if (numeroDebito.length() < 16) {
                    System.out.println("Número inválido.");
                    return;
                }
                System.out.print("Validade (MM/AA): ");
                String validadeDebito = input.nextLine();
                System.out.print("CVV: ");
                String cvvDebito = input.nextLine();
                pagamento = new CartaoDebito(0, c.getNome(), numeroDebito, validadeDebito, cvvDebito);
                metodosPagamento.add(pagamento);
                break;

            case 3:
                System.out.print("\nChave Pix: ");
                String chave = input.nextLine();
                System.out.print("Instituição financeira: ");
                String instituicao = input.nextLine();
                pagamento = new Pix(0, chave, instituicao, c);
                metodosPagamento.add(pagamento);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
        System.out.println("Método de pagamento cadastrado com sucesso!");
    }

}

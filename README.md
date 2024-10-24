
# Pizzaria Online - Sistema de Pedidos e Acesso de Funcionários

## Descrição
Este projeto é um sistema de pedidos para uma pizzaria, desenvolvido em Java. Ele oferece uma interface onde **clientes** podem realizar o login, fazer pedidos de pizzas e acompanhar seu status. Além disso, **funcionários** da pizzaria podem acessar um painel administrativo com funcionalidades específicas, como gerenciamento de pedidos e controle de estoque.

## Funcionalidades

### Para Clientes:
- Login e registro de novos clientes.
- Visualização do menu de pizzas disponíveis.
- Adição de pizzas ao carrinho de compras.
- Finalização de pedidos.
- Acompanhamento do status do pedido.

### Para Funcionários:
- Login exclusivo para funcionários.
- Gerenciamento de pedidos: visualização de pedidos pendentes, em andamento e concluídos.
- Controle de estoque: adicionar, editar ou remover pizzas do menu.

## Tecnologias Utilizadas
- **Linguagem**: Java
- **Interface de Usuário**: Java Swing (ou outra ferramenta de interface, se utilizada)

## Estrutura do Projeto
```bash
/pizzaria-online
│
├── /src
│   ├── /cliente
│   │   ├── Cliente.java
│   │   ├── Pedido.java
│   │   └── Carrinho.java
│   ├── /funcionario
│   │   ├── Funcionario.java
│   │   ├── GerenciamentoPedido.java
│   │   └── ControleEstoque.java
│   ├── Main.java
│   └── DatabaseConnection.java
├── /resources
│   └── database.sql
└── README.md
```

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/pizzaria-online.git
   cd pizzaria-online
   ```

2. **Configure o banco de dados**:
   - Certifique-se de que você tem um banco de dados MySQL rodando.
   - Execute o script SQL localizado em `resources/database.sql` para criar as tabelas necessárias.
   - Atualize a classe `DatabaseConnection.java` com as credenciais corretas para acessar seu banco de dados.

3. **Compile e execute o projeto**:
   - Usando a linha de comando ou um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA ou Eclipse, compile e execute o arquivo `Main.java`.

   Para compilar:
   ```bash
   javac src/Main.java
   ```

   Para executar:
   ```bash
   java src/Main
   ```

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma **issue** ou enviar um **pull request** com melhorias.


Esse README fornece uma visão geral do projeto e pode ser ajustado conforme a evolução das suas funcionalidades e tecnologias.

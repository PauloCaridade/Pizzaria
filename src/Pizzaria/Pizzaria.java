package Pizzaria;
import pagamento.*;
import pessoas.*;

import java.util.ArrayList;

public class Pizzaria {

    public static void main(String[] args) {

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        Pessoa c1 = new Cliente("João",25,"Masculino","Curitiba","(41)999999999",
                "joão@gmail.com","jãojão","12345");


        Pessoa f1 = new Funcionario("Mateus",50,"Masculino","Curitiba","(41)888888888",
                "mateus@outlook.com","atendente",1800,"teuteu","54321");

        Pessoa f2 = new Funcionario("Lucas",21,"Masculino","Curitiba","(41)5555555",
                "lucas123@outlook.com","Pizzaiolo",2500,"luquinha","999");

        Pessoa a1 = new Administrador("Ana",35,"Feminino","Curitiba",
                "(41)777777777","ana@gmail.com","aninha","nana555");

        Funcionario f3 = new Funcionario("Gabriela",22,"Feminino","Curitiba","(41)444444444",
                "gab@hotmail.com","secretária",2500,"gabzinha","202020");

        Funcionario f4 = new Funcionario("Leonardo",42,"Masculino","Curitiba","(41)111111111",
                "leozin@outlook.com","Pizzaiolo",3500,"leleco","777");

        autenticarLogin(c1);
        autenticarLogin(f1);
        pessoas.add(c1);
        pessoas.add(f1);
        pessoas.add(f2);
        pessoas.add(a1);
        funcionarios.add(f3);

        System.out.println("\nPessoas: ");
        dadosPessoas(pessoas);
        System.out.println("\nFuncionários: ");
        dadosFuncionarios(pessoas);
        System.out.println("\nFunções ADM: ");
        adicionarFuncionario(a1,funcionarios,f4);
        listarFuncionarios(a1,funcionarios);
        excluirFuncionario(a1,funcionarios,f4);


        CartaoCredito credito = new CartaoCredito(150.0, "João Silva", "1234567812345678", "12/25", "123", 2000.0);
        System.out.println("Status inicial (Cartão de Crédito): " + credito.statusPagamento());
        credito.pagar();
        System.out.println("Status após pagamento (Cartão de Crédito): " + credito.statusPagamento());
        credito.cancelarPagamento();
        System.out.println("Status após cancelamento (Cartão de Crédito): " + credito.statusPagamento());


        CartaoDebito debito = new CartaoDebito(100.0, "Maria Souza", "8765432187654321", "11/24", "456");
        System.out.println("\nStatus inicial (Cartão de Débito): " + debito.statusPagamento());
        debito.pagar();
        System.out.println("Status após pagamento (Cartão de Débito): " + debito.statusPagamento());
        debito.cancelarPagamento();
        System.out.println("Status após cancelamento (Cartão de Débito): " + debito.statusPagamento());


        Dinheiro dinheiro = new Dinheiro(50.0);
        System.out.println("\nStatus inicial (Dinheiro): " + dinheiro.statusPagamento());
        dinheiro.pagar();
        System.out.println("Status após pagamento (Dinheiro): " + dinheiro.statusPagamento());
        dinheiro.cancelarPagamento();
        System.out.println("Status após cancelamento (Dinheiro): " + dinheiro.statusPagamento());


        Pix pix = new Pix(75.0, "12345678900", "Banco do Brasil");
        System.out.println("\nStatus inicial (Pix): " + pix.statusPagamento());
        pix.pagar();
        System.out.println("Status após pagamento (Pix): " + pix.statusPagamento());
        pix.cancelarPagamento();
        System.out.println("Status após cancelamento (Pix): " + pix.statusPagamento());


    }



    public static void dadosPessoas(ArrayList<Pessoa> pessoas) {
        for(Pessoa pessoa : pessoas){
            System.out.println();
            System.out.println(pessoa);
        }
    }

    public static void dadosFuncionarios(ArrayList<Pessoa> pessoas){
        for(Pessoa pessoa : pessoas){
            if(pessoa instanceof Funcionario f){
                f.dadosFuncionario();
            }
        }
    }

    public static void adicionarFuncionario(Pessoa pessoa, ArrayList<Funcionario> funcionarios, Funcionario f){
        if(pessoa instanceof Administrador adm){
            adm.adicionarFuncionario(f,funcionarios);
        }
    }

    public static void listarFuncionarios(Pessoa pessoa,ArrayList<Funcionario> funcionarios){
        if(pessoa instanceof Administrador adm){
            adm.listarFuncionarios(funcionarios);
        }
    }

    public static void excluirFuncionario(Pessoa pessoa,ArrayList<Funcionario> funcionarios,Funcionario f){
        if(pessoa instanceof Administrador adm){
            adm.excluirFuncionario(f, funcionarios);
        }
    }

    public static void autenticarLogin(Pessoa pessoa){
        if(pessoa instanceof Cliente c){
            System.out.println("Login confirmado: "+ c.autenticar(c.getLogin(),c.getSenha()));
        }
        else if(pessoa instanceof Funcionario f){
            System.out.println("Login confirmado: "+ f.autenticar(f.getLogin(),f.getSenha()));
        }
    }

}

package pessoas;

import java.util.ArrayList;

public interface Administar {

    void adicionarFuncionario(Funcionario f,ArrayList<Funcionario> funcionarios );
    void excluirFuncionario(Funcionario f, ArrayList<Funcionario> funcionarios);
    void listarFuncionarios(ArrayList<Funcionario> funcionarios);
}

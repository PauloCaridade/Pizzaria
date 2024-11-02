package pessoas;

import java.util.ArrayList;

public interface Administar {

    void adicionarFuncionario(Pessoa p,ArrayList<Pessoa> pessoas);
    void excluirFuncionario(Pessoa p, ArrayList<Pessoa> pessoas);
    void listarFuncionarios(ArrayList<Pessoa> pessoas);
}

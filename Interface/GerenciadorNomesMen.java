package Interface;
/**
 * 
 * 
 *  
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */

import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesMen implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<>();

    @Override
    public List<String> obterNomes() {
        return nomes; 
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() <= MAX_CARACTERES_NOMES) {
            nomes.add(nome);
        } else {
            System.out.println("Nome excede o número máximo de caracteres permitidos! "
            		+ "\nPor favor, digite nomes com menos de 20 caracteres");
        }
    }

    @Override
    public boolean removerNome(String nome) {
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equals(nome)) {
                nomes.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean atualizarNome(String nAntigo, String nNovo) {
        if (nNovo.length() > MAX_CARACTERES_NOMES) { 
            System.out.println("O novo nome excede o número máximo de caracteres permitidos!");
            return false;
        }

        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equals(nAntigo)) {
                nomes.set(i, nNovo); 
                System.out.println("Nome atualizado com sucesso.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean buscarNome(String nome) {
        for (String n : nomes) {
            if (n.equals(nome)) {
                return true; 
            }
        }
        return false;
    }
}
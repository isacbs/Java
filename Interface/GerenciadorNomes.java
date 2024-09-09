package Interface;
/**
 * Criação da interface
 * 
 *  
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */

import java.util.List;

public interface GerenciadorNomes {
	
    int MAX_CARACTERES_NOMES = 20;  
    
    List<String> obterNomes();
    
    void adicionarNome(String nome);
    
    boolean removerNome(String nome);
    
    boolean atualizarNome(String nAntigo, String nNovo);
    
    boolean buscarNome(String nome); 
}

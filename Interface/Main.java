package Interface;
/**
 * 
 * 
 *  
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */

public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gNomes = new GerenciadorNomesMen(); 

        gNomes.adicionarNome("Isadora");
        gNomes.adicionarNome("Jennifer");
        gNomes.adicionarNome("Karina");

        System.out.println("Lista Inicial:");
        for (String nome : gNomes.obterNomes()) {
            System.out.println("- " + nome);
        }

        System.out.println("\nAgora você pode adicionar mais nomes ou visualizar a lista completa.");

        Ihm ihm = new Ihm(gNomes);
        ihm.dialogar();
    }
}

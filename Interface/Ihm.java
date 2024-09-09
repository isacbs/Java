package Interface;
/**
 * 
 * 
 *  
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */

import java.util.Scanner;

public class Ihm {
    private GerenciadorNomes gerenciador;
    private Scanner ent = new Scanner(System.in); 

    public Ihm(GerenciadorNomes g) {
        this.gerenciador = g;
    }

    public void dialogar() {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Remover nome");
            System.out.println("3 - Atualizar nome");
            System.out.println("4 - Buscar nome");
            System.out.println("5 - Exibir nomes");
            System.out.println("6 - Sair");

            int opcao = ent.nextInt();
            ent.nextLine(); 

            switch (opcao) {
                case 1:
                    adicionarNome(); 
                    break;
                case 2:
                    removerNome(); 
                    break;
                case 3:
                    atualizarNome(); 
                    break;
                case 4:
                    buscarNome();  
                    break;
                case 5:
                    exibirNomes();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void adicionarNome() {
        System.out.print("Digite o nome para adicionar: ");
        String nome = ent.nextLine();
        gerenciador.adicionarNome(nome); 
    }

    private void removerNome() {
        System.out.print("Digite o nome para remover: ");
        String nome = ent.nextLine();
        if (gerenciador.removerNome(nome)) {
            System.out.println("Nome removido com sucesso"); 
        } else {
            System.out.println("Nome não está contido na lista. \nPor favor digite um nome que está na lista");  
        }
    }

    private void atualizarNome() {
        System.out.print("Digite o nome a ser atualizado: ");
        String nomeAntigo = ent.nextLine(); 
        System.out.print("Digite o novo nome: ");
        String nomeNovo = ent.nextLine();
        if (!gerenciador.atualizarNome(nomeAntigo, nomeNovo)) { 
            System.out.println("O nome a ser atualizado não está contido na lista, "
            		+ "por favor digite um nome válido"); 
        }
    }

    private void buscarNome() {
        System.out.print("Digite o nome para buscar: ");
        String nome = ent.nextLine(); 
        if (gerenciador.buscarNome(nome)) {
            System.out.println("Nome encontrado."); 
        } else {
            System.out.println("Nome não encontrado, por favor digite um nome válido");  
        }
    }

    private void exibirNomes() {
        System.out.println("\nLista de nomes:");
        for (String nome : gerenciador.obterNomes()) {
            System.out.println(nome);  
        }
    }
}
package Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Atleta> atletas = new ArrayList<>();
        atletas.add(new Atleta("Isadora", 24, 9.5));
        atletas.add(new Atleta("Ana Maria", 30, 8.7));
        atletas.add(new Atleta("Karina", 22, 9.2));
        atletas.add(new Atleta("Daniela", 18, 8.9));

        Scanner ent = new Scanner(System.in);
        int op;

        do {
            System.out.println("\nEscolha um critério de ordenação:");
            System.out.println("1. Ordem Alfabética (Comparable)");
            System.out.println("2. Ordem Crescente de Idade (Comparator)");
            System.out.println("3. Ordem Decrescente de Pontuação (Comparator)");
            System.out.println("4. Ordem Alfabética (Comparator)");
            System.out.println("0. Sair");
            op = ent.nextInt();

            switch (op) {
                case 1:
                    Collections.sort(atletas);
                    System.out.println("\nAtletas em ordem alfabética (Comparable):");
                    exibirAtletas(atletas);
                    break;
                case 2:
                    Collections.sort(atletas, new ComparadorPorIdade());
                    System.out.println("\nAtletas em ordem crescente de idade:");
                    exibirAtletas(atletas);
                    break;
                case 3:
                    Collections.sort(atletas, new ComparadorPorPontuacao());
                    System.out.println("\nAtletas em ordem decrescente de pontuação:");
                    exibirAtletas(atletas);
                    break;
                case 4:
                    Collections.sort(atletas, new ComparadorPorNome());
                    System.out.println("\nAtletas em ordem alfabética (Comparator):");
                    exibirAtletas(atletas);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            
        } while (op != 0);

        ent.close();
    }

    public static void exibirAtletas(List<Atleta> atletas) {
        for (Atleta atleta : atletas) {
            System.out.println(atleta);
        }
    }
}
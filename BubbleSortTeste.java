package Lab;

import java.util.Random;

public class BubbleSortTeste {
    private static int cont;

    public static void main(String[] args) {
        int[] tms = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000};

        // Executa testes para cada tamanho de vetor
        for (int tam : tms) {
            int[] vetor = gerarVetorAleatorio(tam);

            cont = 0;
            bubbleSort(vetor);
            
            // Exibe resultado
            System.out.println("Tamanho do vetor: " + tam + " | Comparações: " + cont);
        }
    }

    // Método de ordenação Bubble Sort
    public static void bubbleSort(int[] chaves) {
        int temp;
        // Inicia o Bubble Sort
        for (int i = 0; i < chaves.length; i++) {
            for (int j = 1; j < chaves.length - i; j++) {
                // Incrementa o contador de comparações a cada verificação
                cont++;
                if (chaves[j - 1] > chaves[j]) {
                    // Troca os elementos
                    temp = chaves[j - 1];
                    chaves[j - 1] = chaves[j];
                    chaves[j] = temp;
                }
            }
        }
    }

    // Método para gerar um vetor de números aleatórios
    public static int[] gerarVetorAleatorio(int tam) {
        Random random = new Random();
        int[] vetor = new int[tam];

        // Preenche o vetor com números aleatórios na faixa de 0 a 10 
        for (int i = 0; i < tam; i++) {
            vetor[i] = random.nextInt(tam * 10);
        }

        return vetor;
    }
}

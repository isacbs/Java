package Revisao;

import java.util.Random;

public class BubbleSortTeste {
    private static int cont;

    public static void main(String[] args) {  // Executa os testes e exibe o resultado
        int[] tms = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000};

        for (int tam : tms) {
            int[] vetor = gerarVetorAleatorio(tam);

            cont = 0;
            bubbleSort(vetor);

            System.out.println("Tamanho do vetor: " + tam + " | Trocas: " + cont); 
        }
    }

    public static void bubbleSort(int[] chaves) { // Método de ordenação Bubble Sort
        int temp;
        for (int i = 0; i < chaves.length; i++) {
            for (int j = 1; j < chaves.length - i; j++) { 
                if (chaves[j - 1] > chaves[j]) {
                    temp = chaves[j - 1];
                    chaves[j - 1] = chaves[j];
                    chaves[j] = temp;
                    cont++; 
                }
            }
        }
    }

    public static int[] gerarVetorAleatorio(int tam) { // Método para gerar um vetor de números aleatórios
        Random random = new Random();
        int[] vetor = new int[tam];

        for (int i = 0; i < tam; i++) { 
            vetor[i] = random.nextInt(tam * 10);
        }

        return vetor;
    }
}

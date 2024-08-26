package Excs;

import java.util.Random;

public class VetorCem {

	public static void main(String[] args) {
		/* Cria um vetor de inteiro com 100 posições e preenche o vetor com valores
		aleatórios entre 1 e 300 */
		int[] vetor = new int[100];
		Random random = new Random();

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = random.nextInt(301);
		}

		System.out.println("Vetor preenchido:");
		exibirVetor(vetor);

		inverteVetor(vetor);

		// Exibe o vetor após a inversão
		System.out.println("Vetor resultante após sua inversão:");
		exibirVetor(vetor);
	}

	// Exibe o vetor preenchido
	public static void exibirVetor(int[] vetor) {
		for (int i : vetor) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// Inverte os valores do vetor
	public static void inverteVetor(int[] vetor) {
		int n = vetor.length;
		for (int i = 0; i < n / 2; i++) {
			int array = vetor[i];
			vetor[i] = vetor[n - i - 1];
			vetor[n - i - 1] = array;
		}
	}
}

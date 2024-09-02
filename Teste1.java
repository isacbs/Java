package Lab;

import java.util.Random;

public class Teste1 {
	private static int cont = 0;

	public static void main(String[] args) {
		int[][] A = new int[2][2];
		int[][] B = new int[2][2];

		// Preenche as matrizes A e B com números aleatórios
		preencheA(A);
		preencheB(B);

		// Cria a matriz C para receber o resultado
		int[][] C = new int[A.length][B[0].length];

		C = multiplica(A, B);

		exibeResult(C);

		System.out.println("Número de operações realizadas: " + cont);
	}

	public static void preencheA(int[][] A) {
		Random random = new Random();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = random.nextInt(11);
			}
		}
	}

	public static void preencheB(int[][] B) {
		Random random = new Random();
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				B[i][j] = random.nextInt(11);
			}
		}
	}

	// Multiplicação das duas matrizese e a contagem do número de operações
	public static int[][] multiplica(int[][] A, int[][] B) {
		int[][] C = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				C[i][j] = 0;
				for (int k = 0; k < A[0].length; k++) {
					C[i][j] += A[i][k] * B[k][j];
					cont++;
				}
			}
		}
		return C;
	}

	// Exibição do resultado da matriz C
	public static void exibeResult(int[][] C) {
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
}
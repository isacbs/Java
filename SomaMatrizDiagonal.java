package Matriz;

import java.util.Random;

public class SomaMatrizDiagonal {
	public static void main(String[] args) {
		int[][] matriz = new int[10][10];

		// Preenchendo a matriz com valores aleatórios entre 5 e 50
		Random rand = new Random();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = rand.nextInt(46) + 5;
			}
		}

		// Calculando a soma dos elementos abaixo da diagonal principal
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < i; j++) {
				soma += matriz[i][j];
			}
		}

		// Exibindo a matriz
		System.out.println("Matriz:");
		for (int[] linha : matriz) {
			for (int valor : linha) {
				System.out.print(valor + "\t");
			}
			System.out.println();
		}

		// Exibindo a soma dos elementos abaixo da diagonal principal
		System.out.println("Soma dos elementos abaixo da diagonal principal: " + soma);
	}
}

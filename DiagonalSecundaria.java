package Matriz;

public class DiagonalSecundaria {

	// Fazendo a matriz e a soma para a diagonal secundária
	public static int Secundaria(int[][] matriz) {
		int soma = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				// Verifica se o elemento está na diagonal secundária
				if (i + j == matriz.length - 1) {
					soma += matriz[i][j];
				}
			}
		}

		return soma;
	}

	// Preenchendo a matriz e mostrando o resultado da soma da diagonal secundária
	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3, 4, 5 }, { 0, 2, 4, 6, 8 }, { 3, 7, 10, 13, 17 }, 
				{ 19, 24, 50, 58, 70 }, { 76, 79, 83, 86, 89 } };

		int soma = Secundaria(matriz);
		System.out.println("A soma da diagonal secundária é: " + soma);
	}
}

package Matriz;

/* Faça um MÉTODO que receba como parâmetro uma matriz de quadrada de números inteiros M (5,5) e
retorne a soma dos elementos da diagonal principal desta matriz */

public class DiagonalPrincipal {

	// Fazendo a matriz e a soma para a diagonal principal
	public static int Diagonal(int[][] matriz) {
		int soma = 0;
		for (int i = 0; i < matriz.length; i++) {
			soma += matriz[i][i];
		}
		return soma;
	}

	// Preenchendo a matriz e mostrando o resultado da soma da diagonal principal
	public static void main(String[] args) {
		int[][] matriz = { { 1, 2, 3, 4, 5 }, { 0, 2, 4, 6, 8 }, { 3, 7, 10, 13, 17 }, 
				{ 19, 24, 50, 58, 70 }, { 76, 79, 83, 86, 89 } };

		int soma = Diagonal(matriz);
		System.out.println("A soma da diagonal principal é: " + soma);
	}

}

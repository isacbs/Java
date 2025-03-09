package Revisao;

public class SomaDiagonalPrincipal {

	public static int Diagonal(int[][] matriz) { // Fazendo a matriz e a soma para a diagonal principal
		int soma = 0;
		for (int i = 0; i < matriz.length; i++)
			soma += matriz[i][i];
		return soma;
	}

	public static void main(String[] args) { // Preenchendo a matriz e mostrando o resultado da soma
		int[][] matriz = { { 1, 2, 3, 4, 5 }, { 0, 2, 4, 6, 8 }, { 3, 7, 10, 13, 17 }, 
				{ 19, 24, 50, 58, 70 }, { 76, 79, 83, 86, 89 } };

		int soma = Diagonal(matriz);
		System.out.println("A soma da diagonal principal é: " + soma);
	}

}
package Revisao;

import java.util.Random;

public class EdificioMackVista {
	public static void main(String[] args) {
		int[][] matriz = new int[10][8];
		Random random = new Random();

		for (int i = 0; i < matriz.length; i++) { // Preenchendo a matriz com números aleatórios entre 0 e 6
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = random.nextInt(7);
			}
		}

		int total = 0; // Número Total dos Moradores;
		int andar = 0; // Andar Com Mais Moradores;
		int maxAndar = 0; // Número Máximo de Moradores Por Andar;
		int vazios = 0; // Apartamentos Vazios;

	
		for (int i = 0; i < matriz.length; i++) { // Calculando os valores necessários, contando apartamentos
		 		int soma = 0;						// vazios e o andar com mais moradores
			for (int j = 0; j < matriz[i].length; j++) {
				int moradores = matriz[i][j];
				soma += moradores;

				if (moradores == 0) {
					vazios++;
				}
			}

			if (soma > maxAndar) {
				maxAndar = soma;
				andar = i + 1;
			}

			total += soma;
		}

		System.out.println("Matriz de moradores do Edifício MACK VISTA por apartamento"); // Mostra resultados
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("Quantidade de apartamentos vazios: " + vazios);
		System.out.println("Andar com o maior número de moradores: " + andar);
		System.out.println("Quantidade total de moradores no prédio: " + total);
	}

}
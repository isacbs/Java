package Matriz;

/* O edifício MACK VISTA tem 10 andares e em cada andar existem 8 apartamentos.
   O síndico do prédio resolveu fazer o seguinte levantamento:
	• Quantidade de apartamentos vazios (nº moradores = 0)
	• Qual é o andar que tem o maior número de moradores
	• Quantidade total de moradores do prédio
 */

import java.util.Random;

public class EdificioMackVista {
	public static void main(String[] args) {
		int[][] matriz = new int[10][8];
		Random random = new Random();

		// Preenchendo a matriz com números aleatórios entre 0 e 6
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = random.nextInt(7);
			}
		}

		int total = 0; // Número Total dos Moradores;
		int andar = 0; // Andar Com Mais Moradores;
		int maxAndar = 0; // Número Máximo de Moradores Por Andar;
		int vazios = 0; // Apartamentos Vazios;

		/* Calculando os valores necessários,contando apartamentos vazios e o 
		 andar com mais moradores */
		for (int i = 0; i < matriz.length; i++) {
			int soma = 0; // Soma de Moradores por Andar
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

		// Exibindo a matriz e os resultados
		System.out.println("Matriz de moradores do Edifício MACK VISTA por apartamento");
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

package Matrizes;

import java.util.Scanner;

public class DiagonalPrincipal {

    public static void exibir(int[][] matriz) {  // Método que imprime a diagonal principal
        System.out.print("Diagonal principal: ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) { // Método que preenche a matriz
        Scanner ent = new Scanner(System.in);
        int[][] matriz = new int[4][4];
        
        System.out.println("Digite 16 números, separados por espaço:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = ent.nextInt();
            }
        }
        
        exibir(matriz);
        
        ent.close();
    }
}

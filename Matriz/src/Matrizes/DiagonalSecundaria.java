package Matrizes;

import java.util.Scanner;

public class DiagonalSecundaria {

    public static void exibir(int[][] matriz) { // Método que recebe a matriz
        System.out.print("Diagonal secundária: ");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i][matriz.length - 1 - i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) { // Método principal para preencher a matriz
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
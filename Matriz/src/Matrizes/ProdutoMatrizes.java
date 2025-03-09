package Matrizes;

import java.util.Scanner;

public class ProdutoMatrizes {

    // Método para multiplicar duas matrizes
    public static int[][] multiplicar(int[][] m, int[][] n) {
        int[][] r = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                r[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    r[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        int[][] m = new int[2][4];  // Definindo e preenchendo as matrizes
        int[][] n = new int[4][2];

        System.out.println("Digite os 8 valores para a matriz m, separados por espaço:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = ent.nextInt();
            }
        }

        System.out.println("Digite os 8 valores para a matriz n, separados por espaço:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                n[i][j] = ent.nextInt();
            }
        }

        int[][] r = multiplicar(m, n);

        System.out.println("Matriz resultante da multiplicação m * n:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(r[i][j] + "\t");
            }
            System.out.println();
        }
        ent.close(); 
    }
}
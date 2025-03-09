package Matrizes;

import java.util.Scanner;

public class SomaMatrizes {

    public static double[][] somarMatrizes(double[][] m, double[][] n) {
        double[][] resultado = new double[2][4]; // Método para somar duas matrizes
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                resultado[i][j] = m[i][j] + n[i][j];
            }
        }
        return resultado;
    }

    public static void main(String[] args) { // Preenchendo as matrizes e mostrando o resultado
        Scanner ent = new Scanner(System.in);

        double[][] m = new double[2][4]; // Definindo e preenchendo as matrizes
        double[][] n = new double[2][4];

        System.out.println("Digite 8 valores para a matriz m, separados por espaço:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = ent.nextDouble();
            }
        }

        System.out.println("Digite os 8 valores para a matriz n, separados por espaço:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                n[i][j] = ent.nextDouble();
            }
        }

        double[][] soma = somarMatrizes(m, n);

        System.out.println("Matriz resultante da soma m + n:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(soma[i][j] + "\t");
            }
            System.out.println();
        }

        ent.close();
    }
}
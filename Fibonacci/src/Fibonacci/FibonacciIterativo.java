package Fibonacci;

public class FibonacciIterativo {

    public static int iterativo(int n) { // Método iterativo para calcular Fibonacci
        if (n <= 1) return 1; // Base case
        int a = 1, b = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("Fibonacci iterativo de " + n + " é: " + iterativo(n));
    }
}
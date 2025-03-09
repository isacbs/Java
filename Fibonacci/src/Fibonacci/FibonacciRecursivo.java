package Fibonacci;

public class FibonacciRecursivo {
    public static int recursivo(int n) { // Método recursivo para calcular Fibonacci
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursivo(n - 1) + recursivo(n - 2);   
    }
    
    public static void main(String[] args) {
        int n = 4; 
        System.out.println("Fibonacci recursivo de " + n + " é: " + recursivo(n));
    }
}
package Revisao;

public class Palindroma {

    public static boolean verificar(char[] palavra) {
        int inicio = 0;
        int fim = palavra.length - 1;

        while (inicio < fim) {
            if (palavra[inicio] != palavra[fim]) {
                return false; // Se encontrar caracteres diferentes, não é palíndromo
            }
            inicio++;
            fim--;
        }
        return true; // Se percorreu toda a palavra sem encontrar diferença, é palíndromo
    }

    public static void main(String[] args) {
        char[] palavra = {'A', 'N', 'N', 'A', 'R', 'O', 'T', 'T'};
        boolean resultado = verificar(palavra);
        System.out.println("A palavra é palíndroma? " + resultado);
    }
}
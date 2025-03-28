package Pilha;

public class Aplicacao {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);

        System.out.println("Empilhando os valores!!");
        for (int i = 1; i <= 10; i++) {
            if (pilha.empilhar(i)) {
                System.out.println("Empilhado: " + i);
            } else {
                System.out.println("Falha ao empilhar: " + i);
            }
        }

        System.out.println("Teste \nTentando empilhar além do limite indicado");
        System.out.println(pilha.empilhar(11) ? "Empilhado" : "Pilha cheia");

        System.out.println("Topo da pilha: " + pilha.mostrarTopo());

        System.out.println("Desempilhando os valores!!!");
        while (true) {
            int valor = pilha.desempilhar();
            if (valor == -1) {
                System.out.println("Pilha vazia!");
                break;
            }
            System.out.println("Desempilhado: " + valor);
        }

        System.out.println("Teste: \nTentando mostrar topo da pilha vazia");
        try {
            System.out.println("Topo da pilha: " + pilha.mostrarTopo());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Pilha está vazia.");
        }
    }
}

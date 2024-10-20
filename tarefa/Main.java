package tarefa;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Fila clientes = new Fila(100);

        // declare as variáveis auxiliares
        int cliAtendidos = 0;
        int totalEspera = 0;
        int maiorEspera = 0;
        int tempoCliente;

        // peça para o usuário entrar com a duração da simulação (em minutos)
        Scanner ent = new Scanner(System.in);
        System.out.print("---: Bem vindo a fila de check-in :---");
        
        int duracao = -1; 
        if (duracao < 0) {
            System.out.print("\nInsira o tempo de duração para a realização do teste em minutos: ");
            duracao = ent.nextInt();

            if (duracao < 0) {
                System.out.println("Erro!!!! \nO valor da duração não pode ser negativo" + 
            "\nPor favor digite um número positivo");
            }
        }
        Random r = new Random();

        for (int minuto = 0; minuto < duracao; minuto++) {
            if (!clientes.isEmpty()) {
                // 1- retirar um elemento da fila (lembre de guardar o conteúdo)
                tempoCliente = Integer.parseInt(clientes.front()); 
                clientes.dequeue(); 
                
                // 2- atualize o total de clientes atendidos
                cliAtendidos++;

                // 3- calcule o tempo de espera desse cliente e verifique se é o
                //    maior tempo de espera - atualize o tempo total
                int tempoDeEspera = minuto - tempoCliente;
                totalEspera += tempoDeEspera;

                if (tempoDeEspera > maiorEspera) {
                    maiorEspera = tempoDeEspera;
                }
            }

            // 4- gere o número aleatório determinado, enfileirando a qtde de clientes correspondente
            int k = r.nextInt(3); 
            
            // Se k = 0 nenhum cliente é adicionado, k = 1 é adicionado um cliente e
            // k = 2 são adicionados dois clientes
            if (k == 1) {
                clientes.enqueue(Integer.toString(minuto));  
            } else if (k == 2) {
                clientes.enqueue(Integer.toString(minuto));  
                clientes.enqueue(Integer.toString(minuto));
            }

            // Exibi o estado da fila no minuto atual
            System.out.print("Minuto " + minuto + " - Fila: ");
            if (clientes.isEmpty()) {
                System.out.println("vazia");
            } else {
                System.out.println(clientes);
            }
            System.out.println(" - K: " + k);
        }

        // exibir totais solicitados
        double mediaEspera;
        if (cliAtendidos > 0) {
            mediaEspera = (double) totalEspera / cliAtendidos;
        } else {
            mediaEspera = 0;
        }

        System.out.printf("Número total de clientes atendidos: %d\n", cliAtendidos);
        System.out.printf("Tempo médio de espera na fila: %.2f minutos\n", mediaEspera);
        System.out.printf("Maior tempo de espera na fila: %d minutos\n", maiorEspera);
      
        ent.close();
    }
}
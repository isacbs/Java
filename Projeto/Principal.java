package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Vetor lista = new Vetor(20);
        System.out.println("Bem vindos à competição de Skate Street Feminina nas Olimpíadas de Paris 2024.");
        System.out.println("Agora vamos apresentar os resultados das rodadas.");

        for (int i = 1; i <= 4; i++) { // Leitura dos arquivos das rodadas
            String nomeArq = "rodada" + i + ".txt";
            lerArquivo(nomeArq, lista);
            System.out.println("\nResultados após rodada " + i + ":");
            lista.exibirLista();
            System.out.println();
        }

        Atleta[] finalistas = lista.getFinalistas(); // Entrada manual para a rodada final
        System.out.println("As finalistas e concorrentes às medalhas são:");
        for (Atleta a : finalistas) {
            System.out.println(a.getNome() + " | " + a.getPais());
        }

        Scanner ent = new Scanner(System.in);
        System.out.print("\nDefina a pontuação das oito finalistas na rodada final.");

        for (Atleta a : finalistas) { // Atualização das pontuações das finalistas
            double novaPont = -1;
            while (novaPont < 0 || novaPont > 20) {
                System.out.print("\nDigite a nova pontuação para " + a.getNome() + ", " + a.getPais()
                        + " (Digite um número de 0 a 20):");
                String entrada = ent.nextLine();
                try {
                    novaPont = Double.parseDouble(entrada);
                    if (novaPont < 0 || novaPont > 20) {
                        System.out.println("Número inválido. Digite apenas números entre 0 e 20.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido. Digite apenas números entre 0 e 20.");
                }
            }
            a.setPontuacao(novaPont);
        }

        lista.ordenar(); // Atualizar a lista de atletas com as novas pontuações

        Atleta[] todosAtletas = lista.getAtletas(); // Filtrar medalhistas para garantir que só finalistas recebam medalha
        Atleta[] medals = new Atleta[3];
        int countMedals = 0;

        for (Atleta a : todosAtletas) {
            for (Atleta finalista : finalistas) {
                if (a.equals(finalista)) {
                    if (countMedals < 3) {
                        medals[countMedals] = a;
                        countMedals++;
                    }
                    break;
                }
            }
        }
        
        System.out.println("\nArquivo medalhas.txt foi criado na pasta Projeto.");
        System.out.println("\nCom vocês as medalhistas desses jogos olímpicos:");
        if (countMedals >= 3) {
            System.out.println("A Ganhadora da Medalha de Ouro foi " + medals[0]);
            System.out.println("A Ganhadora da Medalha de Prata foi " + medals[1]);
            System.out.println("A Ganhadora da Medalha de Bronze foi " + medals[2]);

            try (FileWriter writer = new FileWriter("medalhas.txt")) { // Salvar medalhistas no arquivo medalhas.txt
                writer.write("Ouro: " + medals[0] + "\n");
                writer.write("Prata: " + medals[1] + "\n");
                writer.write("Bronze: " + medals[2] + "\n");
            } catch (IOException e) {
                System.out.println("Erro ao gravar o arquivo medalhas.txt");
            }
        } else {
            System.out.println("Não há medalhistas suficientes.");
        }
        ent.close();
    }

    private static void lerArquivo(String nomeArq, Vetor lista) {  // Lê os arquivos e usa o split para dividir a linha pelos caracteres de vírgula
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 3) {
                    String nome = removerEspacos(partes[0]);
                    String pais = removerEspacos(partes[1]);
                    String pont = removerEspacos(partes[2]);
                    double pontuacao;
                    try {
                        pontuacao = Double.parseDouble(pont);
                    } catch (NumberFormatException e) {
                        System.out.println("Erro ao converter pontuação para número: " + pont);
                        continue;
                    }
                    Atleta a = new Atleta(nome, pais, pontuacao);
                    lista.adicionarAtleta(a);
                } else {
                    System.out.println("Formato de linha inválido: " + linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + nomeArq);
        }
    }

    private static String removerEspacos(String s) { // Remove espaços da string e constroi uma nova sem espaços extras
        int inicio = 0;
        while (inicio < s.length() && s.charAt(inicio) == ' ') {
            inicio++;
        }
        int fim = s.length() - 1;
        while (fim >= inicio && s.charAt(fim) == ' ') {
            fim--;
        }
        if (inicio > fim) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = inicio; i <= fim; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
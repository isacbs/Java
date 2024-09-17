package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Vetor lista = new Vetor(20);
        System.out.println("Bem vindos à competição de Skate Street Feminina nas Olimpíadas de Paris 2024.");
        System.out.println("Agora vamos apresentar os resultados das rodadas.");

        // Leitura dos arquivos das rodadas
        for (int i = 1; i <= 4; i++) {
            String nomeArq = "rodada" + i + ".txt";
            lerArquivo(nomeArq, lista);
            System.out.println("\nResultados após rodada " + i + ":");
            lista.exibirLista();
            System.out.println();
        }

        // Entrada manual para a rodada final
        ArrayList<Atleta> finalistas = lista.getFinalistas();
        System.out.println("As finalistas e concorrentes às medalhas são:");
        for (Atleta a : finalistas) {
            System.out.println(a.getNome() + " | " + a.getPais());
        }

        Scanner ent = new Scanner(System.in);
        System.out.print("\nDefina a pontuação das oito finalistas na rodada final.");

        // Atualização das pontuações das finalistas
        for (Atleta a : finalistas) {
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

        // Atualizar a lista de atletas com as novas pontuações
        lista.adicionarAtletas(finalistas);
        lista.ordenar();

        // Filtrar medalhistas para garantir que só finalistas recebam medalhas
        ArrayList<Atleta> medals = new ArrayList<>();
        for (Atleta a : lista.getAtletas()) {
            if (finalistas.contains(a)) {
                medals.add(a);
            }
        }

        // Mostrar medalhistas
        System.out.println("\nArquivo medalhas.txt foi criado na pasta Projeto.");
        System.out.println("\nCom vocês as medalhistas desses jogos olímpicos:");
        if (medals.size() >= 3) {
        	
            // Garante que os medalhistas são realmente finalistas
            System.out.println("A Ganhadora da Medalha de Ouro foi " + medals.get(0));
            System.out.println("A Ganhadora da Medalha de Prata foi " + medals.get(1));
            System.out.println("A Ganhadora da Medalha de Bronze foi " + medals.get(2));
            
            // Salvar medalhistas em medalhas.txt
            try (FileWriter writer = new FileWriter("medalhas.txt")) {
                writer.write("Ouro: " + medals.get(0) + "\n");
                writer.write("Prata: " + medals.get(1) + "\n");
                writer.write("Bronze: " + medals.get(2) + "\n");
            } catch (IOException e) {
                System.out.println("Erro ao gravar o arquivo medalhas.txt");
            }
        } else {
            System.out.println("Não há medalhistas suficientes.");
        }
        ent.close();
    }

    // Le os arquivos e usa o split para dividir a linha pelos caracteres de vírgula
    private static void lerArquivo(String nomeArq, Vetor lista) {
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

    // Remove espaços da string e constroi uma nova sem espaços extras
    private static String removerEspacos(String s) {
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
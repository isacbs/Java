package Projeto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Vetor lista = new Vetor(20);

        for (int i = 1; i <= 4; i++) {
            String nomeArq = "rodada" + i + ".txt";
            lerArquivo(nomeArq, lista);
            System.out.println("Resultados após rodada " + i + ":");
            lista.exibirLista();
            System.out.println();
        }

        // Entrada manual para a rodada final
        ArrayList<Atleta> finalistas = lista.getFinalistas();
        System.out.println("Finalistas:");
        for (Atleta a : finalistas) {
            System.out.println(a.getNome() + " - " + a.getPais());
        }

        Scanner ent = new Scanner(System.in);

        for (Atleta a : finalistas) {
            double novaPont = -1;
            while (novaPont < 0 || novaPont > 20) {
                System.out.println("\nDigite a nova pontuação para " + a.getNome() + ", " + a.getPais()
                + " (Digite um número de 0 a 20):");

                String entrada = ent.nextLine();
                try {
                    novaPont = Double.parseDouble(entrada);
                    if (novaPont < 0 || novaPont > 20) {
                        System.out.println("Entrada inválida. Digite um número entre 0 e 20:");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Digite um número entre 0 e 20:");
                }
            }
            a.setPontuacao(novaPont);
        }

        lista.adicionarAtleta(new Atleta("", "", 0));

        // Mostrar medalhistas
        ArrayList<Atleta> medalhistas = lista.getFinalistas();
        System.out.println("\nArquivo medalhas.txt foi criado na pasta Projeto.");
        System.out.println("Medalhistas:");
        if (medalhistas.size() >= 3) {
            System.out.println("Ouro: " + medalhistas.get(0));
            System.out.println("Prata: " + medalhistas.get(1));
            System.out.println("Bronze: " + medalhistas.get(2));

            // Salvar medalhistas em medalhas.txt
            try (java.io.PrintWriter writer = new java.io.PrintWriter("medalhas.txt")) {
                writer.println("Ouro: " + medalhistas.get(0));
                writer.println("Prata: " + medalhistas.get(1));
                writer.println("Bronze: " + medalhistas.get(2));
            } catch (IOException e) {
                System.out.println("Erro ao gravar o arquivo medalhas.txt");
            }
        } else {
            System.out.println("Não há medalhistas suficientes.");
        }

        ent.close();
    }

    private static void lerArquivo(String nomeArq, Vetor lista) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Processar a linha caractere por caractere
                String nome = "";
                String pais = "";
                String pont = "";
                boolean leNome = true;
                boolean lePais = false;

                for (char c : linha.toCharArray()) {
                    if (c == ',') {
                        if (leNome) {
                            leNome = false;
                            lePais = true;
                        } else if (lePais) {
                            lePais = false;
                        }
                    } else {
                        if (leNome) {
                            nome += c;
                        } else if (lePais) {
                            pais += c;
                        } else {
                            pont += c;
                        }
                    }
                }

                // Remover espaços extras manualmente
                nome = removerEspacos(nome);
                pais = removerEspacos(pais);
                pont = removerEspacos(pont);

                double pontuacao;
                try {
                    pontuacao = Double.parseDouble(pont);
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter pontuação para número: " + pont);
                    continue;
                }

                Atleta a = new Atleta(nome, pais, pontuacao);
                lista.adicionarAtleta(a);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + nomeArq);
        }
    }

    // Remove espaços da string
    private static String removerEspacos(String str) {
        int inicio = 0;
        while (inicio < str.length() && str.charAt(inicio) == ' ') {
            inicio++;
        }

        int fim = str.length() - 1;
        while (fim >= inicio && str.charAt(fim) == ' ') {
            fim--;
        }

        if (inicio > fim) {
            return "";
        }

        // Construa a nova string sem espaços extras
        StringBuilder sb = new StringBuilder();
        for (int i = inicio; i <= fim; i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
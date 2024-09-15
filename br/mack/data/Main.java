package br.mack.data;

/*
 * Método principal que inicializa a interface do usuário.
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @author Jennifer Aparecida de Sousa Tondade
 * 
 * @tia 10420646
 * @tia 10420574
 * 
 * **/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);

        /**
         * Entrada do nome do arquivo de texto
         * 
         * 
         * **/ 
        System.out.println("Digite o nome do arquivo de entrada (com extensão .txt):");
        String arqEnt = ent.nextLine();

        /**
         * Leitura do arquivo de entrada
         * 
         * 
         * **/
        String text = lerArquivo(arqEnt);
        if (text == null) {
            System.err.println("Erro ao ler o arquivo de entrada.");
            return;
        }
        System.out.println("Digite o nome do arquivo de palavras ofensivas (com extensão .txt):");
        String arqPalavrasOfensivas = ent.nextLine();

        /**
         * Criação da lista de processadores de texto
         * 
         * 
         * **/ 
        List<ProcessadorTexto> processadores = new ArrayList<>();
        processadores.add(new RemoverEspacosProcessador());
        processadores.add(new RemoverCaracteresEspeciaisProcessador());
        processadores.add(new RemoverPalavrasOfensivasProcessador(arqPalavrasOfensivas));

        /**
         * Execução dos processadores
         * 
         * 
         * **/
        String textPro = text;
        for (ProcessadorTexto processador : processadores) {
            textPro = processador.processar(textPro);
        }

        /**
         * Gera um arquivo de saída com o texto processado
         * 
         * 
         * **/ 
        String nomeArqSaida = gerarNomeArquivoSaida(arqEnt);
        escreverArquivo(nomeArqSaida, textPro);
    }

    /**
     * O conteúdo de um arquivo é lido e retorna como uma string 
     * 
     * 
     * **/
    private static String lerArquivo(String nomeArq) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArq))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            return null;
        }
        return conteudo.toString();
    }

    /**
     * Adiciona "_processado" ao nome do arquivo de entrada para ser o arquivo de saída
     * 
     * 
     * **/
    private static String gerarNomeArquivoSaida(String nomeArqEnt) {
        int pontoIndex = nomeArqEnt.lastIndexOf('.');
        if (pontoIndex != -1) {
            return nomeArqEnt.substring(0, pontoIndex) + "_processado.txt";
        } else {
            return nomeArqEnt + "_processado.txt";
        }
    }

    /**
     * Escreve o conteúdo em um arquivo com o nome especificado
     * 
     *  
     * **/
    private static void escreverArquivo(String nomeArq, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArq))) {
            writer.write(conteudo);
            System.out.println("Arquivo processado salvo como: " + nomeArq);
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}
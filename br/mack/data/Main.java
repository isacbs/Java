package br.mack.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada do nome do arquivo de texto
        System.out.println("Digite o nome do arquivo de entrada (com extensão .txt):");
        String arquivoEntrada = scanner.nextLine();

        // Leitura do arquivo de entrada
        String texto = lerArquivo(arquivoEntrada);
        if (texto == null) {
            System.err.println("Erro ao ler o arquivo de entrada.");
            return;
        }

        // Entrada do nome do arquivo de palavras ofensivas
        System.out.println("Digite o nome do arquivo de palavras ofensivas (com extensão .txt):");
        String arquivoPalavrasOfensivas = scanner.nextLine();

        // Criação dos processadores
        List<ProcessadorTexto> processadores = new ArrayList<>();
        processadores.add(new RemoverEspacosProcessador());
        processadores.add(new RemoverCaracteresEspeciaisProcessador());
        processadores.add(new RemoverPalavrasOfensivasProcessador(arquivoPalavrasOfensivas));

        // Encadeamento dos processadores
        String textoProcessado = texto;
        for (ProcessadorTexto processador : processadores)
            textoProcessado = processador.processar(textoProcessado);

        // Gerar arquivo de saída com o texto processado
        String nomeArquivoSaida = gerarNomeArquivoSaida(arquivoEntrada);
        escreverArquivo(nomeArquivoSaida, textoProcessado);
    }

    private static String lerArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
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

    private static String gerarNomeArquivoSaida(String nomeArquivoEntrada) {
        int pontoIndex = nomeArquivoEntrada.lastIndexOf('.');
        if (pontoIndex != -1)
            return nomeArquivoEntrada.substring(0, pontoIndex) + "_processado.txt";
        else
            return nomeArquivoEntrada + "_processado.txt";
    }

    private static void escreverArquivo(String nomeArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            System.out.println("Arquivo processado salvo como: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
    
}
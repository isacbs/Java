package br.mack.data;

/**
 * Classe responsável por processar texto, removendo palavras ofensivas
 * de acordo com uma lista fornecida de um arquivo.
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @author Jennifer Aparecida de Sousa Tondade
 * 
 * @tia 10420646
 * @tia 10420574
 **/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoverPalavrasOfensivasProcessador extends ProcessadorTexto {
    private List<String> palavrasOfensivas;

    /**
     * Construtor que inicializa a lista de palavras ofensivas
     * carregando-as de um arquivo fornecido.
     * 
     * 
     */
    public RemoverPalavrasOfensivasProcessador(String arqFonte) {
        this.palavrasOfensivas = carregarPalavrasOfensivas(arqFonte);
    }

    /**
     * Carrega a lista de palavras ofensivas a partir de um arquivo.
     * 
     *
     */
    private List<String> carregarPalavrasOfensivas(String arqFonte) {
        List<String> palavras = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arqFonte))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                palavras.add(linha.toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar palavras ofensivas: " + e.getMessage());
        }
        return palavras;
    }

    /**
     * Processa o texto removendo palavras ofensivas e mantendo a formatação original.
     *
     *
     */
    @Override
    protected String executar(String text) {
        StringBuilder res = new StringBuilder();
        StringBuilder palavraAtual = new StringBuilder();
        boolean dentroDePalavra = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Verifica se o caractere é parte de uma palavra (letra ou dígito)
            if (Character.isLetterOrDigit(c)) {
                palavraAtual.append(c);
                dentroDePalavra = true;
            } else {
                if (dentroDePalavra) {
                    String palavra = palavraAtual.toString().toLowerCase();
                    if (isPalavraOfensiva(palavra)) {
                        res.append("[REMOVIDO]");
                    } else {
                        res.append(palavraAtual);
                    }
                    palavraAtual.setLength(0);
                    dentroDePalavra = false;
                }
                res.append(c);
            }
        }

        // Verifica a última palavra após o loop
        if (palavraAtual.length() > 0) {
            String palavra = palavraAtual.toString().toLowerCase();
            if (isPalavraOfensiva(palavra)) {
                res.append("[REMOVIDO]");
            } else {
                res.append(palavraAtual);
            }
        }

        return res.toString();
    }

    /**
     * Verifica se uma palavra está na lista de palavras ofensivas.
     * 
     * 
     */
    private boolean isPalavraOfensiva(String palavra) {
        for (String palavraOfensiva : palavrasOfensivas) {
            if (palavra.equals(palavraOfensiva)) {
                return true;
            }
        }
        return false;
    }
}
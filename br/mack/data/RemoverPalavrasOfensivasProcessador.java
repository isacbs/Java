package br.mack.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoverPalavrasOfensivasProcessador extends ProcessadorTexto {
    private List<String> palavrasOfensivas;

    public RemoverPalavrasOfensivasProcessador(String arquivoConfiguracao) {
        this.palavrasOfensivas = carregarPalavrasOfensivas(arquivoConfiguracao);
    }

    private List<String> carregarPalavrasOfensivas(String arquivoConfiguracao) {
        List<String> palavras = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoConfiguracao))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                palavras.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar palavras ofensivas: " + e.getMessage());
        }
        return palavras;
    }

    @Override
    protected String executar(String texto) {
        StringBuilder resultado = new StringBuilder();
        StringBuilder palavraAtual = new StringBuilder();
        boolean dentroDePalavra = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                // Construção de uma palavra
                palavraAtual.append(c);
                dentroDePalavra = true;
            } else {
                // Final de uma palavra
                if (dentroDePalavra) {
                    String palavra = palavraAtual.toString();
                    if (isPalavraOfensiva(palavra)) {
                        resultado.append("[REMOVIDO]");
                    } else {
                        resultado.append(palavra);
                    }
                    palavraAtual.setLength(0);  // Limpa o acumulador de palavras
                    dentroDePalavra = false;
                }
                // Adiciona o caractere delimitador ao resultado
                resultado.append(c);
            }
        }

        // Verifica a última palavra, caso exista
        if (palavraAtual.length() > 0) {
            String palavra = palavraAtual.toString();
            if (isPalavraOfensiva(palavra)) {
                resultado.append("[REMOVIDO]");
            } else {
                resultado.append(palavra);
            }
        }

        return resultado.toString();
    }

    private boolean isPalavraOfensiva(String palavra) {
        // Verifica se a palavra está na lista de palavras ofensivas
        for (String palavraOfensiva : palavrasOfensivas) {
            if (palavra.equalsIgnoreCase(palavraOfensiva)) {
                return true;
            }
        }
        return false;
    }
    
}
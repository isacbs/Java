package br.mack.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class RemoverPalavrasOfensivasProcessador implements ProcessadorTexto {
    private Set<String> palavrasOfensivas;

    public RemoverPalavrasOfensivasProcessador() {
        this.palavrasOfensivas = carregarPalavrasOfensivas("palavras_ofensivas.txt");
    }

    private Set<String> carregarPalavrasOfensivas(String nomeArquivo) {
        Set<String> palavras = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                palavras.add(linha.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar palavras ofensivas: " + e.getMessage());
        }
        return palavras;
    }

    @Override
    public String processar(String texto) {
        String[] palavras = texto.split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palavra : palavras) {
            if (palavrasOfensivas.contains(palavra.toLowerCase())) {
                resultado.append("[REMOVIDO]").append(" ");
            } else {
                resultado.append(palavra).append(" ");
            }
        }
        return resultado.toString().trim();
    }
}

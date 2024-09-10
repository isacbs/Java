package br.mack.data;

public class RemoverCaracteresEspeciaisProcessador implements ProcessadorTexto {
    @Override
    public String processar(String texto) {
        // Remove todos os caracteres que não são letras, números ou espaços
        return texto.replaceAll("[^a-zA-Z0-9\\s]", "");
    }
}

package br.mack.data;

public class RemoverEspacosProcessador implements ProcessadorTexto {
    @Override
    public String processar(String texto) {
        // Remove múltiplos espaços e substitui por um único espaço
        return texto.replaceAll("\\s+", " ").trim();
    }
}

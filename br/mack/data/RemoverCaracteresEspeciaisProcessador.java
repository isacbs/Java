package br.mack.data;

public class RemoverCaracteresEspeciaisProcessador extends ProcessadorTexto {
    @Override
    protected String executar(String texto) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == ' ') {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }
    
}
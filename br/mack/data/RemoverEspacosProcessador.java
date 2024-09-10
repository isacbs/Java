package br.mack.data;

public class RemoverEspacosProcessador extends ProcessadorTexto {
    @Override
    protected String executar(String texto) {
        StringBuilder resultado = new StringBuilder();
        boolean espacoAnterior = false;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == ' ') {
                if (!espacoAnterior) {
                    resultado.append(c);
                    espacoAnterior = true; 
                }
            } else {
                resultado.append(c);
                espacoAnterior = false;
            }
        }
        return resultado.toString();
    }
    
}
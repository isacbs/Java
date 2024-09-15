package br.mack.data;

/**
 * Classe responsável por remover caracteres especiais do texto.
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @author Jennifer Aparecida de Sousa Tondade
 * 
 * @tia 10420646
 * @tia 10420574
 * 
 * **/ 

public class RemoverCaracteresEspeciaisProcessador extends ProcessadorTexto {
	
	/**
     * Remove caracteres especiais do texto, mantendo apenas letras, dígitos e espaços.
     *
     *
     */
    @Override
    protected String executar(String text) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9') || c == ' ') {
                res.append(c);
            }
        }

        return res.toString();
    }
    
}
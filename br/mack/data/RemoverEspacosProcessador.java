package br.mack.data;

/**
 * Classe responsável por remover espaços consecutivos do texto. 
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @author Jennifer Aparecida de Sousa Tondade
 * 
 * @tia 10420646
 * @tia 10420574
 * 
 * **/

public class RemoverEspacosProcessador extends ProcessadorTexto {
	
	/**
     * Remove espaços consecutivos do texto, mantendo apenas um espaço entre palavras.
     * 
     * 
     */
    @Override
    protected String executar(String text) {
        StringBuilder res = new StringBuilder();
        boolean esp = false;
        
        // Verifica se o caractere é um espaço e adiciona o espaço somente se não for um espaço consecutivo
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                if (!esp) {
                    res.append(c);
                    esp = true;
                }
            } else {
                res.append(c);
                esp = false;
            }
        }
        return res.toString();
    }
}
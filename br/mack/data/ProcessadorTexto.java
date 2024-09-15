package br.mack.data;

/**
 * Classe abstrata que define o comportamento de um processador de texto.
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @author Jennifer Aparecida de Sousa Tondade
 * 
 * @tia 10420646
 * @tia 10420574
 * 
 * **/

public abstract class ProcessadorTexto {
    protected ProcessadorTexto proximo;

    /**
     * Define o próximo processador
     * 
     * 
     */
    public ProcessadorTexto definirProximo(ProcessadorTexto proximo) {
        this.proximo = proximo;
        return proximo;
    } 

    /**
     * Processa o texto chamando o método executar() e passa o resultado para o próximo processador
     * 
     * 
     */
    public String processar(String text) {
        text = executar(text);
        if (proximo != null) {
            return proximo.processar(text);
        }
        return text;
    }

    /**
     * Método abstrato obrigatoriamente implantado nas subclasses para definir as suas especificações.
     * 
     *
     */
    protected abstract String executar(String text);
}
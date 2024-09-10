package br.mack.data;

public abstract class ProcessadorTexto {
    protected ProcessadorTexto proximo;

    public ProcessadorTexto definirProximo(ProcessadorTexto proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public String processar(String texto) {
        texto = executar(texto);
        if (proximo != null) {
            return proximo.processar(texto);
        }
        return texto;
    }

    protected abstract String executar(String texto);
}
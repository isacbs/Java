package Projeto;

public class Atleta {
    private String nome;
    private String pais;
    private double pontuacao;

    public Atleta(String nome, String pais, double pontuacao) {
        this.nome = nome;
        this.pais = pais;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return nome + " | " + pais + " | " + pontuacao;
    } 
}
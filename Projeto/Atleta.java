package Projeto;

/**
* Desenvolvedoras: 
*
* @author Isabella Sofia Martins @tia 10420398
*
* @author Isadora Caetano Brandão de Sousa @tia 10420646
*
* @author Jennifer Aparecida de Sousa Tondade @tia 10420574
*
* **/
 
public class Atleta {  
    private String nome;
    private String pais;
    private double pontuacao;

    public Atleta(String nome, String pais, double pontuacao) {
        this.nome = nome;
        this.pais = pais;
        this.pontuacao = pontuacao;
    }

    //getters e setters
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

    @Override //formatacao do texto 
    public String toString() {
        return nome + " | " + pais + " | " + pontuacao;
    }  
}
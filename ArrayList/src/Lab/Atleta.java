package Lab;

public class Atleta implements Comparable<Atleta> {
    private String nome;
    private int idade;
    private double pontuacao;

    public Atleta(String nome, int idade, double pontuacao) {
        this.nome = nome;
        this.idade = idade;
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    @Override
    public int compareTo(Atleta outro) {
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public String toString() {
        return "Atleta: Nome " + nome + ", Idade " + idade + ", Pontuação " + pontuacao + ".";
    }
    
}
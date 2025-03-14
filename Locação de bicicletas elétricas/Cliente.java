package Projeto;

/**
* Desenvolvedoras: 
*
*
* @author Isadora Caetano Brandão de Sousa @ra 10420646
*
* @author Luana Fernandes @ra 10439810
*
*
* **/

public class Cliente {
    String nome;
    String cpf;
    double totalGasto;
    boolean bicicletaAlugada;
    int quantidadeLocacoes;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.totalGasto = 0.0;
        this.bicicletaAlugada = false;
        this.quantidadeLocacoes = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public boolean isBicicletaAlugada() {
        return bicicletaAlugada;
    }

    public int getQuantidadeLocacoes() {
        return quantidadeLocacoes;
    }

    public void locarBicicleta() {
        this.bicicletaAlugada = true;
        this.totalGasto += 5.00;
        this.quantidadeLocacoes++;
    }

    public void devolverBicicleta() {
        this.bicicletaAlugada = false;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTotal Gasto: R$ " + totalGasto +
               "\nBicicleta Alugada: " + (bicicletaAlugada ? "Sim" : "Não") + 
               "\nTotal de Locações: " + quantidadeLocacoes;
    }

}
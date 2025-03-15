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
    private String nome;
    private String cpf;
    private double totalGasto;
    private boolean bicicletaAlugada;
    private int quantidadeLocacoes;

    /**
     * Construtor da classe Cliente, que inicializa os atributos 
     *
     * @param nome Nome do cliente;.
     * @param cpf CPF do cliente;
     * @param totalGasto Total gasto das locações feitas pelo cliente;
     * @param bicicletaAlugada Checa se a bicicleta está alugada no momento;
     * @param quantidadeLocacoes Quantidade de locações que o cliente fez.
     */
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.totalGasto = 0.0;
        this.bicicletaAlugada = false;
        this.quantidadeLocacoes = 0;
    }

    /**
     * Retorna os atributos
     * 
     * @return nome do cliente;.
     * @return cpf do cliente;
     * @return total gasto das locações feitas pelo cliente;
     * @return true se a bicicleta estiver alugada, false caso não esteja;
     * @return quantidade de locações que o cliente fez.
     * 
     */
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

    /**
     * Realiza a locação de uma bicicleta, aumentando o total gasto e a quantidade de locações.
     * 
     */
    public void locarBicicleta() {
        this.bicicletaAlugada = true;
        this.totalGasto += 5.00;
        this.quantidadeLocacoes++;
    }

    /**
     * Devolve a bicicleta, alterando o estado da locação.
     * 
     */
    public void devolverBicicleta() {
        this.bicicletaAlugada = false;
    }

    /**
     * String com as informações do cliente.
     * 
     */
    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTotal Gasto: R$ " + totalGasto +
               "\nBicicleta Alugada: " + (bicicletaAlugada ? "Sim" : "Não") +
               "\nTotal de Locações: " + quantidadeLocacoes;
    }
    
}

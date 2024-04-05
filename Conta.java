package excs;

public class Conta {
	// Atributos
	String nomeCli;
	int numConta;
	int senhaConta;
	
	// Construtor
	Conta (String Nome, int num, int senha) {
		nomeCli = Nome;
		numConta = num;
		senhaConta = senha;
	}
	
	// Métodos
	public void mostraConta () {
		System.out.print("Nome do Correntista: " + nomeCli);
		System.out.print("Número da Conta: " + numConta);
		System.out.print("Digite sua senha: " + senhaConta);
	}
	
	public boolean validaSenha(int senha) {
		return (senhaConta == senha);
	}
}

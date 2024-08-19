package Exceptions;

public class InsufficientFundsException extends Exception {
	private double valor;
	private double balance;

	// Exceção deve ser lançada quando houver tentativa de saque de um valor maior do que o saldo disponível na conta
	public InsufficientFundsException(double valor, double balance) {
		super("Valor inválido, só é possível fazer o saque de um valor menor ou igual ao do saldo disponível na conta. "
				+ "\nSaque inválido: R$ " + valor + ", Saldo atual: R$ " + balance + ".");
		this.valor = valor;
		this.balance = balance;
	}

	// Getters
	public double getValor() {
		return valor;
	}

	public double getBalance() {
		return balance;
	}

}
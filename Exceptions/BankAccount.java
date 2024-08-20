package Exceptions;

public class BankAccount {
	private int accountNumber;
	private double balance;
	private String accountHolderName;

	public BankAccount(int accountNumber, String accountHolderName, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	// Método para Depósito
	public void deposit(double valor) {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor para depósitos não pode ser negativo!! \nDepósito invalidado de R$" + valor  + ".");
		}
		balance += valor;
		System.out.println(
				"Depósito de " + valor + " reais realizado com sucesso. O valor do saldo atual é R$ " + balance + ".");
	}

	// Método para Saque
	public void withdraw(double valor) throws InsufficientFundsException {
		if (valor < 0) {
			throw new IllegalArgumentException("O valor do saque não pode ser negativo!! \nSaque invalidado de R$" + valor  + ".");
		}
		if (valor > balance) {
			throw new InsufficientFundsException(valor, balance);
		}
		balance -= valor;
		System.out.println(
				"Saque de " + valor + " reais realizado com sucesso. O valor do saldo atual é R$ " + balance + ".");
	}

	// Getters
	public double getBalance() {
		return balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

}

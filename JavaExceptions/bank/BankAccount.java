package br.dev.joaquim.bank;

import br.dev.joaquim.exceptions.ErrorCode;
import br.dev.joaquim.exceptions.InsufficientFoundsException;

/**
 * Simboliza uma conta bancária com número de conta, saldo e nome do titular.
 * 
 * 
 * @author 10420646
 */
public class BankAccount {
	private int accountNumber;
	private double balance;
	private String accountHolderName;

	/**
	 * Construtor para criar uma conta bancária com valores iniciais.
	 * 
	 * @param accountNumber     Número da conta
	 * @param balance           Saldo inicial da conta
	 * @param accountHolderName Nome do titular da conta
	 */
	public BankAccount(int accountNumber, double balance, String accountHolderName) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
	}

	/**
	 * Adquiri o número da conta.
	 * 
	 * @return Número da conta
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Adquiri o saldo da conta.
	 * 
	 * @return Saldo da conta
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Adquiri o nome do titular da conta.
	 * 
	 * @return Nome do titular da conta
	 */
	public String getAccountHolderName() {
		return accountHolderName;
	}

	/**
	 * Deposita um valor na conta, se o valor for negativo, lança uma exceção.
	 * 
	 * @param value Valor a ser depositado
	 * @throws IllegalArgumentException Se o valor for negativo
	 */
	public void deposit(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("O valor precisa ser positivo. Valor informado: R$ " + value);
		}
		this.balance += value;
	}

	/**
	 * Saca um valor da conta. Se o valor for negativo ou se houver saldo
	 * insuficiente, lança uma exceção.
	 * 
	 * @param value Valor a ser sacado
	 * @throws InsufficientFoundsException Se o valor solicitado for maior que o
	 *                                     saldo
	 * @throws IllegalArgumentException    Se o valor for negativo
	 */
	public void withdraw(double value) throws InsufficientFoundsException {
		if (value <= 0) {
			throw new IllegalArgumentException("O valor deve ser positivo. Valor informado: R$ " + value);
		}
		if (value > this.balance) {
			throw new InsufficientFoundsException(ErrorCode.INSUFFICIENT_BALANCE);
		}
		this.balance -= value;
	}

	@Override
	public String toString() {
		return "Conta " + accountNumber + " de " + accountHolderName + " tem um saldo de R$ " + balance;
	}
}

package Exceptions;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		BankAccount account = new BankAccount(97543, "Isadora Caetano", 100);

		try {
			// Exibe os dados iniciais da conta
			System.out.println("---:: Informações da Conta ::---");
			System.out.println("Número da conta: " + account.getAccountNumber());
			System.out.println("Nome do titular: " + account.getAccountHolderName());
			System.out.println("Saldo inicial: R$ " + account.getBalance());

			// Solicita ao usuário o valor do depósito e do saque
			System.out.print("\nInforme o valor desejado para fazer o depósito: ");
			double dep = ent.nextDouble();
			account.deposit(dep);

			System.out.print("\nInforme o valor desejado para fazer o saque: ");
			double saque = ent.nextDouble();
			account.withdraw(saque);

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}

		ent.close();
	}
}

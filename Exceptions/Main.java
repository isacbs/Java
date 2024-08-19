package Exceptions;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ent = new Scanner(System.in);
		BankAccount account = new BankAccount("97543", "Isadora Caetano");

		try {
			// Solicita ao usuário o valor do depósito
			System.out.print("Informe o valor desejado para fazer o depósito: ");
			double deposito = ent.nextDouble();
			account.deposit(deposito);

			// Solicita ao usuário o valor do saque
			System.out.print("Informe o valor desejado para fazer o saque: ");
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

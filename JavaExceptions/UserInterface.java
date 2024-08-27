package br.dev.joaquim;

import java.util.Random;
import java.util.Scanner;

import br.dev.joaquim.bank.BankAccount;
import br.dev.joaquim.exceptions.InsufficientFoundsException;

public class UserInterface {
	private Scanner input = new Scanner(System.in);
	private BankAccount account;

	private void welcome() { 
		System.out.println("Bem-vindo ao sistema bancário");
		System.out.print("Vamos criar usa conta, informe seu nome: ");
		String holderName = input.nextLine();
		int accountNumber = (new Random()).nextInt(1000, 9999);
		System.out.println("Criamos uma conta com o número: " + accountNumber + ", com saldo igual a 0 (zero).");
		this.account = new BankAccount(accountNumber, 0, holderName);
	}

	private void showMenu() {
		System.out.println("\n\n-----------------------");
		System.out.println("Escolha uma das opções:");
		System.out.println("\t1. Verificar dados da conta.");
		System.out.println("\t2. Depositar.");
		System.out.println("\t3. Sacar.");
		System.out.println("\t4. Sair.");
		System.out.print("opção > ");
	}

	public void start() {
		welcome();
		if (account == null)
			return;

		while (true) {
			showMenu();
			try {
				int choice = readOption();
				switch (choice) {
				case 1:
					System.out.println("\n" + this.account);
					break;
				case 2:
					deposit();
					break;
				case 3:
					withdraw();
					break;
				case 4:
					System.out.println("Até a próxima.");
					return;
				default:
					System.out.println("Opção inválida");
					break;
				}
				waitUser();
			} catch (NumberFormatException ex) {
				System.out.println("Valor informado não é um número");
			} catch (IllegalArgumentException | InsufficientFoundsException ex) {
				System.out.println(ex);
			}
		}
	}

	private void deposit() {
		System.out.print("\nInforme o valor a ser depositado: ");
		double value = readValue();
		account.deposit(value);
		System.out.println("Desposito realizado com sucesso.");
	}

	private void withdraw() throws InsufficientFoundsException {
		System.out.print("\nInforme o valor a ser sacado: ");
		double value = readValue();
		account.withdraw(value);
		System.out.println("Saque realizado com sucesso");
	}

	private int readOption() {
		String choiceString = input.nextLine();
		return Integer.parseInt(choiceString);
	}

	private double readValue() {
		String line = input.nextLine();
		return Double.parseDouble(line);
	}

	private void waitUser() {
		System.out.println("pressione ENTER para continuar...");
		input.nextLine();
	}
}

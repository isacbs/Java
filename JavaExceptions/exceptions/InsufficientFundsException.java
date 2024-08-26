package br.dev.joaquim.exceptions;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(String message) {
		super(message);
	}

	public InsufficientFundsException() {
		super("Saldo insuficiente para realizar a operação.");
	}

	public InsufficientFundsException(String message, Throwable cause) {
		super(message, cause);
	}
}

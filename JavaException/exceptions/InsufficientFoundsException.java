package br.dev.joaquim.exceptions;

/**
 * Exceção lançada quando há saldo insuficiente para realizar uma operação. 
 * 
 * 
 * @author 10420646
 */
public class InsufficientFoundsException extends Exception {

	private static final long serialVersionUID = 1L;

	private final ErrorCode code;

	/**
	 * Construtor para criar uma exceção com um código de erro específico.
	 * 
	 * @param errorCode Código de erro que descreve o tipo de erro.
	 */
	public InsufficientFoundsException(ErrorCode code) {
		super("Saldo insuficiente para realizar a operação.");
		this.code = code;
	}

	/**
	 * Construtor para criar uma exceção com uma mensagem específica e um código de
	 * erro.
	 * 
	 * @param message   Mensagem que descreve o erro.
	 * @param errorCode Código de erro que descreve o tipo o erro.
	 */
	public InsufficientFoundsException(String message, ErrorCode code) {
		super(message);
		this.code = code;
	}

	/**
	 * Adquiri o código de erro associado a esta exceção.
	 * 
	 * @return Código de erro.
	 */
	public ErrorCode getErrorCode() {
		return code;
	}
}

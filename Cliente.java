package excs;

public class Cliente {
	// Atributos
	String nomeCompleto;
	int codCliente;

	// Construtor
	public Cliente(int codigoCliente) {
		this.codCliente = codigoCliente;
	}

	// Métodos
	public void inserirNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String retornarNomeCompleto() {
		return nomeCompleto;
	}

	public int retornarCodigoCliente() {
	    return codCliente;
	}

}
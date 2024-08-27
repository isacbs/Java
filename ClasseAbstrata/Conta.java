package br.dev.joaquim;

public abstract class Conta {
	protected double saldo;
	private int numero;
	
	public Conta(int numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public abstract boolean sacar(double valor);
	
	public boolean depositar(double valor) {
		if(valor < 0) { return false; }
		saldo += valor;
		return true;
	}
	
	@Override
	public String toString() {
		return "Conta [" + numero + "] com saldo = R$ " + saldo;
	}
}

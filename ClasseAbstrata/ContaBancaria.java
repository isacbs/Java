package br.dev.joaquim;

public class ContaBancaria extends Conta {

	public ContaBancaria(int numero, double saldo) {
		super(numero, saldo);
	}
	
	@Override
	public boolean sacar(double valor) {
		if(valor > saldo) {
			return false;
		}
		saldo -= valor;		
		return true;
	}

}

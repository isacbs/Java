package br.dev.joaquim;

public class ContaEspecial extends Conta {
	private double limite;
	
	public ContaEspecial(int numero, double saldo, double limite) {
		super(numero, saldo);
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(double valor) {
		if(valor > saldo + limite) {
			return false;
		}
		saldo -= valor;		
		return true;
	}
	
	public boolean aumentar(double valor) {
		if(valor < 0) return false;
		limite += valor;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - limite de R$ " + limite;
	}

}

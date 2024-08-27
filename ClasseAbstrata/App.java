package br.dev.joaquim;

public class App {
	public static void main(String[] args) {
		Conta[] contas = {
				new ContaEspecial(1, 10, 100),
				new ContaBancaria(2,0),
				new ContaEspecial(3, 0, 10)
		};
		
		for(int i=0; i<contas.length; i++) {
			if(contas[i] instanceof ContaEspecial) {
				ContaEspecial ce = (ContaEspecial) contas[i];
				ce.aumentar(10);
//				((ContaEspecial)contas[i]).aumentar(10);
			} else {
				contas[i].depositar(97);
			}
			System.out.println(contas[i]);
		}
	}
}

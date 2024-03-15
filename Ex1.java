package sub_rotina;

import java.util.Scanner;

public class Ex1 {
	
	static double valorPagamento(double compra, int diasAtraso) {
		double multa = 0.0;
		double juros = 0.0;	
		if (diasAtraso > 0) {
			multa = 0.03 * compra;
			juros = 0.01 * diasAtraso * compra;
			return compra + multa + juros;
		}
		else {
			return compra;
		}
		
	}

	public static void main(String[] args) {
		
		Scanner ent = new Scanner(System.in);
		System.out.print("Informar o valor da compra: R$");
		double compraValor = ent.nextDouble();
		System.out.print("Dias de atraso: ");
		int diasEmAtraso = ent.nextInt();
		
		double total = valorPagamento(compraValor, diasEmAtraso);
		
		System.out.printf("Valor a pagar: %.2f\n", total );
		
		ent.close();	
	}

}

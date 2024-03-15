package sub_rotina;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		Scanner ent = new Scanner (System.in);
		System.out.print("Informe o primeiro valor: ");
		double n1 = ent.nextDouble();
		System.out.print("Informe o segundo valor: ");
		double n2 = ent.nextDouble();
		
		System.out.println("Menu de opções: ");
		System.out.println("1. Soma");
		System.out.println("2. Subtração");
		System.out.println("3. Multiplicação");
		System.out.println("4. Divisão");
		System.out.println("Opção: ");
		int opcao = ent.nextInt();
		switch (opcao) {
		case 1:
			System.out.printf("Resultado:", n1, n2, somar(n1,n2));
			break;
		case 2:
			System.out.printf("Resultado:", n1, n2, subtrair(n1,n2));
			break;
		case 3:
			System.out.printf("Resultado:", n1, n2, multiplicar(n1,n2));
			break;
		case 4:
			System.out.printf("Resultado de %f por %f é igual a %f ", n1, n2, n1/n2);
			break;
		default:
			System.out.println("Opção inválida!!!!!!!!!!");	
		}
		
		ent.close();
	}
	
	static double somar(double x, double y) {
		return x + y;
	}
	
	static double subtrair(double x, double y) {
		return x - y;
	}
	
	static double multiplicar(double x, double y) {
		return x * y;
	}
	
	static void dividir(double x, double y) {
		
		if (y != 0) {
			System.out.printf("Resultado de %f por %f é igual a %f ", x, y, x/y);
		}
		else {
			System.out.println("Não é possível dividir um número por 0");
		}
	}

}

package Lab2;

import java.util.Scanner;

public class TestaCPF {
	 public static void main(String[] args) {
		 Scanner ent = new Scanner(System.in);

	     System.out.println("Digite o número do CPF na forma XXX.XXX.XXX-XX : ");
	     String teste = ent.nextLine();

	     CPF cpf = new CPF();
	     cpf.cadastrar(teste);

	     if (cpf.validar()) 
	    	 System.out.println("CPF válido: " + cpf.formatar());
	     else 
	         System.out.println("CPF inválido: " + cpf.formatar());

	    
	     ent.close();
	 }
	 
}
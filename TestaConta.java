package excs;

import java.util.Scanner;

public class TestaConta {
	public static void main(String[] args) {
	    Scanner ent = new Scanner(System.in);
	    
	    Conta minhaConta = new Conta("João Paulo", 123456, 8079);
	    System.out.println("-:: Dados da conta ::-");
	    minhaConta.mostraConta();
	    System.out.print("Digite sua senha: ");
	    
	    int senha = ent.nextInt();
	    String msg = "A senha está " + (minhaConta.validaSenha(senha) ? "Correta" : "Incorreta");
	    		
	    System.out.println(msg);		
	    		
	    ent.close();
	}
}

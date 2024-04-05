package excs;

public class TesteCliente {
	 public static void main(String[] args) {
		 // Instanciando dois objetos Cliente
	     Cliente cliente1 = new Cliente(1);
	     Cliente cliente2 = new Cliente(2);
	     
	     cliente1.inserirNomeCompleto("Ana Brandão");
	     cliente2.inserirNomeCompleto("Ellen Oliveira");

	     // Imprimindo o nome do cliente antes de atribuir valor
	     System.out.println("Nome do Cliente 1: " + cliente1.retornarNomeCompleto());
	     System.out.println("Nome do Cliente 2: " + cliente2.retornarNomeCompleto());

	     // Atribuindo valores aos nomes dos clientes
	     cliente1.inserirNomeCompleto("Isadora Caetano");
	     cliente2.inserirNomeCompleto("Deize Cavalcante");

	     // Imprimindo o nome do cliente depois de atribuir valor
	     System.out.println("Nome do Cliente 1: " + cliente1.retornarNomeCompleto());
	     System.out.println("Nome do Cliente 2: " + cliente2.retornarNomeCompleto());
	    }
	}
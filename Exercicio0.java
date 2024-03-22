package classes;

public class Exercicio0 {

	public static void main(String[] args) {
		// Declaração de um objeto e a instanciação do objeto
		Lâmpada neon = new Lâmpada();
		
		// Outros objetos
		Lâmpada letreiro = new Lâmpada();
		Lâmpada iluminacaoDaSala = new Lâmpada();
		
		// Mensagem para acender a lâmpada neon
		System.out.println("Acendendo o painel ");
		neon.ligar();
		System.out.println("Condição do painel de neon ");
		System.out.println(neon.condicao());
		
		iluminacaoDaSala.ligar();
		
		System.out.println("Condição das lâmpadas");
		System.out.println("Painel de neon: " + neon.condicao());
		System.out.println("Letreiro luminoso: " + letreiro.condicao());
		System.out.println("Iluminação da sala: " + iluminacaoDaSala.condicao());
		
		
	}

}

package classes;

// Crie uma classe lâmpada que seja capaz de modelar seu estado (acesa/apagada) e que disponha dos comportamentos ligar e desligar

public class Lâmpada {
	// Atributos
	boolean ligada = false;
	
	// Métodos
	void ligar() {
		ligada = true;
	}
	
	void desligar() {
		ligada = false;
	}
	
	String condicao() {
		return "A lâmpada está " + ((ligada) ? "acesa" : "apagada");
	}
}

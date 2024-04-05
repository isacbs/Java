package excs;

public class Pixel {
	int x, y;
	int r, g, b;
	
	// Construtor Padrão 
	public Pixel() {
		x = y = 0;
		r = g = b = 0x00;
	}
	
	// Construtor Padronizado para a Posição
	public Pixel(int x, int y) {
		setCoordenadas(x, y);
	}
	
	// Construtor Padronizado para a Inicialização
	public Pixel(int x, int y, int r, int g, int b) {
		setCoordenadas(x, y);
		setCor(r,g,b);
	}
	// Método que define as coordenadas do pixel na imagem.
	void setCoordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// Método que define os valores de cor em RGB
	void setCor(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	// Método que apresenta as informações sobre o pixel na forma: (x, y) e #(R, G, B)
	String print() {
		return "(" + x + "," + y + ") e #(" + r + "," + g + "," + b +")";
	}
}

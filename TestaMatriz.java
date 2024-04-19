package Lab2;

public class TestaMatriz {
	public static void main(String[] args) {
		
		Matriz m = new Matriz(5, 5);
		
		m.defTitulo(0, "Filial");
		m.defTitulo(1, "Janeiro");
		m.defTitulo(2, "Fevereiro");
		m.defTitulo(3, "Março");
		m.defTitulo(4, "Abril");
		
		double[][] dados = { { 101, 123.78, 145.45, 169.81, 152.37 },
				{ 202, 234.89, 253.42, 232.19, 247.41 },
				{ 303, 67.32, 73.15, 81.02, 79.13 }, 
				{ 404, 48.13, 49.78, 50.22, 48.97 },
				{ 505, 7654.32, 6987.64, 7193.21, 6023.81 } };
		
		for (int i = 0; i < m.linha; i++)
			m.preencher(i, dados[i]);
		
		m.exibir();
		
		double[] totais = m.totalColuna();
		
		System.out.println("\nTotais por Coluna:");
		for (int i = 0; i < totais.length; i++)
			System.out.printf("%-5s - %.2f%n", m.titulo[i], totais[i]);
	}

}
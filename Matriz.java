package Lab2;

public class Matriz {
	public int linha;
	public int coluna;
	public String[] titulo;
	public double[][] info;

	// Criação dos objetos da classe Matriz
	public Matriz(int linhas, int colunas) {
		this.linha = linhas;
		this.coluna = colunas;
		this.titulo = new String[colunas];
		this.info = new double[linhas][colunas];
	}

	// Método que recuperar uma informação armazenada em alguma célula da matriz
	public double recuperar(int linha, int coluna) {
		return info[linha][coluna];
	}

	// Método que armazenar uma informação em uma determinada célula da matriz
	public void armazenar(int linha, int coluna, double dados) {
		info[linha][coluna] = dados;
	}

	// Método que retorna, na forma de um vetor, o conjunto contendo todos os valores de uma certa linha
	public double[] retornarLinha(int linha) {
		return info[linha];
	}

	// Método que preenche uma determinada linha da matriz com os dados provenientes
	// de um vetor de comprimento igual ao número de colunas informado como argumento
	public void preencher(int linha, double[] dados) {
		for (int i = 0; i < coluna; i++)
			info[linha][i] = dados[i];
	}

	// Método que retorna a soma dos valores que fazem parte da mesma coluna damatriz
	public double[] totalColuna() {
		double[] totais = new double[coluna];
		for (int i = 0; i < coluna; i++) {
			double total = 0;
			for (int j = 0; j < linha; j++)
				total += info[j][i];

			totais[i] = total;
		}
		return totais;
	}

	// Tomando um vetor de nomes como parâmetro, definir todos os títulos das colunas de uma só vez
	public void defTitulo(int coluna, String titulos) {
		titulo[coluna] = titulos;
	}

	// Apresentar na tela a visualização do conteúdo do objeto e sua forma tabular
	public void exibir() {
		System.out.print("   |");
		for (String titulo : titulo)
			System.out.printf("%-10s|", titulo);
		System.out.println();
		for (int i = 0; i < linha; i++) {
			System.out.printf("%-3d|", i + 1);
			for (int j = 0; j < coluna; j++) {
				if (info[i][j] % 1 == 0)
					System.out.printf("%10.0f|", info[i][j]);
				else
					System.out.printf("%10.2f|", info[i][j]);
			}

			System.out.println();
		}
	}
}
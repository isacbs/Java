package Matriz;

public class ExMatriz {
	
	public static void main(String[] args) {
		int [][] mat = new int[5][5];
		
		// Preenche a matriz
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				mat[i][j] = (int)(Math.random()*10);
			}
		}
		
		// Exibe a matriz gerada
		for(int i = 0; i < mat.length; i++) {
			System.out.println(" ");
			for(int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
		}
		
		// Exibe a soma das linhas da matriz
		int somaLinha;
		for(int i = 0; i < mat.length; i++) {
			somaLinha = 0;
			for(int j = 0; j < mat[i].length; j++) {
				somaLinha += mat[i][j];
			}
			System.out.println("\nSoma da linha " + i + " = " + somaLinha);
		}
		
	}

}

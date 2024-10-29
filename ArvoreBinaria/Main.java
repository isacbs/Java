package ArvoreBinaria;

public class Main {

	public static void main(String[] args) throws Exception {
		ArvoreBinaria diretorio = new ArvoreBinaria();
		diretorio.addRaiz(new Node("Trab"));
		diretorio.addEsq(new Node("Estrutura de dados"), diretorio.raiz);
		diretorio.addDir(new Node("Programação de Sistemas II"), diretorio.raiz);
	}
	
}
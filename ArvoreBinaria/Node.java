package ArvoreBinaria;

public class Node {
	String elemento;
	Node pai;
	Node esq;
	Node dir;
	
	public Node(String elemento) {
		this.elemento = elemento;
		pai = esq = dir = null;
	}
	
	public void showNode() {
		System.out.println(elemento + " ");
	}
	 
}
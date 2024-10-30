package ArvoreBinaria;

public class Node {
	String elemento; // elemento armazenado no nó
    Node left, right, parent; // apontadores do nó

    Node(String elemento) {
        this.elemento = elemento;
        left = right = parent = null;
    }
    
    public void showNo(){
        System.out.print(elemento + " - ");
    }
     
}
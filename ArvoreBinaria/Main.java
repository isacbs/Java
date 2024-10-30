package ArvoreBinaria;

public class Main {	
	public static void main(String[] args) throws Exception{
        BinaryTree diretorio = new BinaryTree();
        
        Node n1 = new Node ("RAIZ");
        diretorio.addRoot(n1);
        
        Node n2 = new Node ("MACKENZIE");
        diretorio.addLeft(n2, n1);
        Node n3 = new Node ("PESSOAL");
        diretorio.addRight(n3, n1);
        
        Node n4 = new Node ("TRABALHOS");
        diretorio.addLeft(n4, n2);
        Node n5 = new Node ("PROGRAMAS");
        diretorio.addRight(n5, n2);
        
        Node n6 = new Node ("LPII");
        diretorio.addLeft(n6, n5);
        Node n7 = new Node ("ESTRUTURA");
        diretorio.addRight(n7, n5); 
        
        System.out.println("PRÉ-ORDEM"); 
        diretorio.visitPreOrdem(diretorio.root);
        System.out.println("\nIN-ORDEM");
        diretorio.visitInOrdem(diretorio.root);
        System.out.println("\nPOS-ORDEM");
        diretorio.visitPosOrdem(diretorio.root);        
    }
}
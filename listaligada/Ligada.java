package listaligada;

public class Ligada {
	public static void main(String[] args) {
		LinkedList zoo = new LinkedList();
		
		Node n1 = new Node("Gato");
		zoo.addFirst(n1);
		zoo.addFirst(new Node("Mamba Negra"));
		zoo.addFirst(new Node("Corvo"));
		zoo.addLast(new Node("Lobo"));
		zoo.addLast(new Node("Borboleta"));
		
		zoo.showList();
	}
} 
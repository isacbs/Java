package listaligada;

public class Node {
	String animal; // elemento armazenado no nó
	Node next; // próximo elemento da lista

	public Node(String animal) {
		this.animal = animal;
		this.next = null;
	}
	
	public void showAnimal() {
		// Mostra o nome do animal que está na lista
		System.out.println("Animal ==>" + animal);
	}
}

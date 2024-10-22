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

	public String getNomeAnimal() {
		// Devolve o nome do animal
		return animal;
	}

	public void setnomeAnimal(String animal) {
		// Altera elemento armazenado no nó
		this.animal = animal;
	}

	public Node getNext() {
		// Devolve o próximo elemento do nó
		return next;
	}

	public void setNext(Node no) {
		// Altera o apontador next do nó para um novo nó n
		this.next = no;
	}
}
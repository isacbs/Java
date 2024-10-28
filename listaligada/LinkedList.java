package listaligada;

public class LinkedList {
	Node header; // início da lista ligada
	Node trailer; // final da lista ligada
	int size; // quantidade de elementos na lista ligada

	public LinkedList() {
		// inicializa a lista como vazia
		header = null;
		trailer = null;
		size = 0;
	}

	public int size() {
		// retorna o tamanho da lista
		return size;
	}

	public boolean isEmpty() {
		// verifica se a lista está vazia
		if (size == 0)
			return true;
		else
			return false;
	}
	
	public boolean removeFirst() {
		if(isEmpty())
			return false;
		header = header.next;
		size--;
		if(isEmpty()) // removeu o único nó existente na lista 
			trailer = null;
		return true;
	}
	
	public boolean removeLast(String elemento) {
		if(isEmpty())
			return false;
		elemento = trailer.animal;
		return remove(elemento);
	}
	
	public boolean remove(String elemento) {
		Node atual, anterior;
		atual = header;
		anterior = null;
		
		if(isEmpty()) 
			return false;
		
		// se é a cabeça da lista
		if(header.animal.equals(elemento)) {
			header = atual.next;
			size--;
			return true;
		}
		
		anterior = atual;
		atual = atual.next;
		
		while(atual != null) {
			if(atual.animal.equals(elemento)) {
				anterior.next = atual.next;	
				size--;
				// se a remoção for o último elemento
				if(atual == trailer)
					trailer = anterior;
				return true;
			}
			else {
				anterior = atual;
				atual = atual.next;
			}
		}
		return false; // não encontrou o elemento
	}
	

	public Node first() {
		// retorna o Nó inicial da lista
		return header;
	}

	public Node last() {
		// retorna o último Nó da lista
		return trailer;
	}

	public void addFirst(Node novo) {
		// adiciona um novo nó no início da lista 
		if (isEmpty()) {
			header = novo;
			trailer = novo;
		} else {	
			novo.next = header;
			header = novo;
		}
		size++;	
	}

	public void addLast(Node novo) {
		// adiciona um novo nó no final da lista
		if (isEmpty()) {
			header = novo;
			trailer = novo;
		} else {	
			trailer.next = novo;
			trailer = novo;
		}
		size++;
	}
	
	public void showList() {
		Node aux = header;
		aux.showAnimal();
		while (aux.next != null) {
			aux.next= aux;
			aux.showAnimal();
		}
		System.out.println("Fim da lista");
	}
}

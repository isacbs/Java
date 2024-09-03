package Teste;

public class Lista {
	private String[] vetor; // Armazena os elementos do vetor
	private int capacity; // Capacidade do vetor
	private int size; // Elementos no vetor

	public Lista(int capacity) {
		vetor = new String[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	public int size() {
		return size;
	}

	// Retorna o elemento i da lista
	public String get(int i) throws Exception {
		if (i >= size)
			throw new Exception("Posição inválida!!! \nEscolha outra");
		return vetor[i];
	}

	// Altera o valor de i para valor de n
	public void set(int i, String n) throws Exception {
		if (i >= size)
			throw new Exception("Posição inválida!!! \nEscolha outra");
		vetor[i] = n;
	}

	// Adiciona um novo elemento (n) na posição i
	public void add(int i, String n) throws Exception {
		if(size == vetor.length) 
			throw new Exception("Lista cheia!! \nImpossível inserir...");
		if(i>size)
			throw new Exception("Posição inválida para inserção!!");
		for (int j = size-1;j >= i; j--) {
			vetor[j+1] = vetor[j];
		}
		vetor[i] = n;
		size++;
	}

	// Remove o elemento da posição i
	public void remove(int i) throws Exception {
		if(i>=size)
			throw new Exception("Posição inválida para exclusão!!");
		for (int j = i; j<size-2; j++) {
			vetor[j] = vetor[j+1];	
		}
		size--;
	}

	/*public String search(String n) {
		return n;	
	}*/

	public String[] getArray() {
		return vetor;
	}
	
}
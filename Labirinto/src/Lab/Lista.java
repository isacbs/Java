package Lab;

public class Lista {
	private int[] vetor; // Armazena os elementos
	private int capacity; // Capacidade do vetor
	private int size; // Elementos no vetor

	public Lista(int capacity) {
		this.vetor = new int[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	// Verifica se a lista está vazia
	public boolean isEmpty() {
		return size == 0;
	}

    // Retorna o size de elementos na lista
	public int size() {
		return size;
	}

	// Retorna o conteúdo do elemento i da lista
	public int get(int i) throws Exception {
		if (isEmpty())
			throw new Exception("A lista está vazia!");
		if (i < 0 || i >= size)
			throw new Exception("Posição inválida!");
		return vetor[i];
	}

	// Adiciona um novo elemento (n) na posição i
	public void add(int valor) throws Exception {
		if (size == capacity)
			throw new Exception("Lista cheia!");
		vetor[size] = valor;
		size++;
	}

	// Exibe o conteúdo da lista
	public void exibir() {
		for (int i = 0; i < size; i++) {
			System.out.print(vetor[i] + " ");
		}
		System.out.println();
	}

	// Remove o último elemento da lista
	public void remove() throws Exception {
		if (isEmpty())
			throw new Exception("Lista vazia!");
		size--;
	}
	
}
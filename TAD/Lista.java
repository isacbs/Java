package TAD;

public class Lista {
	private String[] vetor; // Armazena os elementos do vetor
	private int capacity; // Capacidade do vetor
	private int size; // Elementos no vetor

	public Lista(int capacity) {
		vetor = new String[capacity];
		this.capacity = capacity;
		this.size = 0;
	}

	// Verifica se a lista está vazia
	public boolean isEmpty() {
		if (size == 0)
			return true;
		else
			return false;
	}

	// Retorna o size de elementos na lista
	public int size() {
		return size;
	}

	// Retorna o conteúdo do elemento i da lista
	public String get(int i) throws Exception {
		if (isEmpty()) 
            throw new Exception("A lista está vazia!!");
		if (i < 0 || i >= size)
			throw new Exception("Posição inválida!!! \nEscolha outra");
		return vetor[i];
	}

	// Altera oconteúdo do elemento i para valor de n
	public void set(int i, String n) throws Exception {
		if (isEmpty()) 
            throw new Exception("A lista está vazia!!");
		if (i < 0 || i >= size)
			throw new Exception("Posição inválida!!! \nEscolha outra");
		vetor[i] = n;
	}

	// Adiciona um novo elemento (n) na posição i
	public void add(int i, String n) throws Exception {
		if(size == vetor.length) 
			throw new Exception("Lista cheia!! \nImpossível inserir...");
		if(i < 0 ||i > size)
			throw new Exception("Posição inválida para inserção!!");
		for (int j = size-1;j >= i; j--) {
			vetor[j] = vetor[j - 1];
		}
		vetor[i] = n;
		size++;
	}

	// Remove o elemento da posição i
	public void remove(int i) throws Exception {
		if (isEmpty())
            throw new Exception("A lista está vazia!! \nImpossível remover qualquer item");
		if(i < 0 || i > size - 1)
			throw new Exception("Posição inválida para exclusão!!");
		for (int j = i; j<size-2; j++) {
			vetor[j] = vetor[j+1];	
		}
		size--;
	}

	// Procura a posição onde está busca
	public int search(String busca){
        for (int i = 0; i<size; i++){
            if (vetor[i].equals(busca))
                return i;
        }
        return -1;
    }

	 // Exibe o conteúdo da lista
	public void mostraLista(){
        for (int i = 0; i< size;i++)
            System.out.print(vetor[i] + " ");
        System.out.println("\nFIM DA LISTA!!");
    }
}
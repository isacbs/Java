package tadlista;

public class Lista {
    Gamer[] vetor; // Tipo da lista
    int tamanho; // Capacidade máxima
    int qtde; // Qtde elementos atual

    public Lista(int tamanho) {
        this.tamanho = tamanho;
        vetor = new Gamer[tamanho];
        qtde = 0;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return qtde == 0;
    }

    // Retorna a qtde de elementos na lista
    public int size() {
        return qtde;
    }

    // Retorna o conteúdo da posição p
    public Gamer get(int p) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= qtde) {
            throw new Exception("Posição inválida");
        }
        return vetor[p];
    }

    // Substitui o conteúdo de p por novo
    public void set(int p, Gamer novo) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= qtde) {
            throw new Exception("Posição inválida");
        }
        vetor[p] = novo;
    }

    // Adiciona o novo elemento na posição p
    public void add(int p, Gamer novo) throws Exception {
        if (qtde == tamanho) {
            throw new Exception("A lista está cheia! Impossível inserir.");
        }
        if (p < 0 || p > qtde) {
            throw new Exception("Posição inválida");
        }
        for (int i = qtde; i > p; i--) {
            vetor[i] = vetor[i - 1];
        }
        vetor[p] = novo;
        qtde++;
    }

    // Remove o elemento da posição p
    public void remove(int p) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia! Impossível remover.");
        }
        if (p < 0 || p >= qtde) {
            throw new Exception("Posição inválida!");
        }
        for (int i = p; i < qtde - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        qtde--;
    }

    // Procura a posição onde está busca
    public int search(Gamer busca) {
        for (int i = 0; i < qtde; i++) {
            if (vetor[i].equals(busca))
                return i;
        }
        return -1;
    }

    // Exibe o conteúdo da lista
    public void mostraLista() {
        for (int i = 0; i < qtde; i++)
            System.out.print(vetor[i] + " | ");
        System.out.println("FIM DA LISTA!!");
    }  
}

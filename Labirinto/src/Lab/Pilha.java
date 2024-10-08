package Lab;
 
public class Pilha {
    private Lista lista; // Instância da lista
    private int top; // Topo da pilha

    public Pilha(int capacity) {
    // Cria uma pilha com uma capacidade inicial
        this.lista = new Lista(capacity);
        this.top = -1;
    }
    
    public int size() {
    // Devolve o número de elementos da pilha
        return top + 1; 
    }

    public void push(int n) throws Exception {
    // Empilha, caso a pilha não esteja cheia, o elemento n   
        top++;
        lista.add(n);
    }

    // Desempilha o elemento do topo
    public int pop() throws Exception {
    // Desempilha, caso a pilha não esteja vazia, o elemento do topo    
    	int n = lista.get(top); 
        lista.remove();
        top--;
        return n;
    }

    public int top() throws Exception {
    // Devolve (não desempilha)o elemento do topo se a pilha não estiver vazia    
    	return lista.get(top); 
    }

    public boolean isEmpty() {
    // Verifica se a pilha está vazia
        return top == -1; 
    }
}  
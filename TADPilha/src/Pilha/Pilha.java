package Pilha;

public class Pilha {
	    private int[] p;
	    private int topo = -1;
	    
	    public Pilha(int tamanho) {
	    	p = new int[tamanho];
	    }
	    
	    private boolean pilhaVazia() {
	    	if (topo == -1)
	    		return true;
	    	else
	    		return false;
	    }
	    
	    private boolean pilhaCheia() {
	    	if (topo == p.length - 1)
	    		return true;
	    	else
	    		return false;
	    }

	    public boolean empilhar(int valor) {
	        if (pilhaCheia())
	        		return false;
	        	topo++;
	        	p[topo] = valor;
	        	return true;
	    }
	    
	    public int desempilhar() {
	    	if (pilhaVazia())
	    		return -1;
	    	else
	    		return p[topo--];
	    }
	    
	    public int mostrarTopo() {
	    	return p[topo];
	    }
}
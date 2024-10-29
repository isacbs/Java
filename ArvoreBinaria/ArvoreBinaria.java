package ArvoreBinaria;

public class ArvoreBinaria {
	Node raiz;

	public ArvoreBinaria() {
		raiz = null;
	}

	public void addRaiz(Node n) throws Exception {
		if (raiz != null)
			throw new Exception("A árvore já tem raiz!!!");
		raiz = n;
	}

	public void addEsq(Node n, Node m) throws Exception { // adiciona n como filha a esquerda de m
		if(m.esq != null)
			throw new Exception("Esse nó já tem um filho á esquerdo!!!");
		m.esq = n;
		n.pai = m;
	}

	public void addDir(Node n, Node m) throws Exception { // adiciona n como filha a direita de m
		if(m.dir != null)
			throw new Exception("Esse nó já tem um flho á direita!!!");
		m.dir = n;
		n.pai = m;
	}
	
	public boolean isFolha(Node n) {
		if (n.esq == null && n.dir == null)
			return true;
		else
			return false;
	}
	
	public boolean isInterno(Node n) {
		if(n.dir != null || n.esq != null)
			return true;
		else
			return false;
	}
	
}
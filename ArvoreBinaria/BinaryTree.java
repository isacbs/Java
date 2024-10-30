package ArvoreBinaria;

public class BinaryTree {
	Node root;

    BinaryTree() {
    // Cria uma árvore binária vazia
        root = null;
    }
    
    public boolean isEmpty(){
        // verifica se a árvore está vazia
        if (root==null)
            return true;
        else
            return false;
    }
    
    public void addRoot(Node n) throws Exception{
        // adiciona o Nó e como raiz
        if (isEmpty())
            throw new Exception ("Árvore já tem raiz");
        root = n;        
    } 
    
    public Node root(){
        //retorna a raiz da árvore
        return root;
    }
    
    public boolean isInternal(Node n){
        // verifica se o nó e é interno ou não
        if (n.left!=null || n.right!=null)
            return true;
        else
            return false;
    }
    
    public boolean isLeaf(Node n){
        // verifica se o nó e é folha ou não
        if (n.left==null && n.right==null)
            return true;
        else
            return false;
    }
    
    public void addLeft(Node n, Node m) throws Exception{
        // adiciona n como filho esquerdo de m
        // n = filho
        // m  = pai
        if (m.left!=null)
            throw new Exception ("Já existe filho esquerdo");
        m.left = n;
        n.parent = m;
    }
    
    public Node left (Node n){
        // retorna o filho à esquerda de n
        return n.left;
    }
    
    public boolean hasLeft(Node n){
        // verifica se n tem ou não filho à esquerda
        if (n.left!=null)
            return true;
        else
            return false;
    }
    
    public void addRight(Node n, Node m) throws Exception{
        // adiciona n como filho direito de m
        // n = filho
        // m  = pai
        if (m.right!=null)
            throw new Exception ("Já existe filho direito");
        m.right = n;
        n.parent = m;
    }
    
    public Node right (Node n){
        // retorna o filho à direita de n
        return n.right;
    }
    
    public boolean hasRight(Node n){
        // verifica se n tem ou não filho à direita
        if (n.right!=null)
            return true;
        else
            return false;
    }
    
    public void remove(Node n){
        //remove o n com todos os descendentes
        if (n==root)
            root = null;
        else
            if (n.parent.left == n)
                n.parent.left = null;
            else
                if (n.parent.right == n)
                    n.parent.right = null;            
    }
     
    public void visitPreOrdem(Node n){
        // exibe todos os nós na forma RED
        if (n == null)
            return;
        n.showNo();
        visitPreOrdem(n.left);
        visitPreOrdem(n.right);
    }
    
    public void visitPosOrdem(Node n){
        // exibe todos os nós na forma EDR
        if (n == null)
            return;        
        visitPosOrdem(n.left);
        visitPosOrdem(n.right);
        n.showNo();
    }
    
    public void visitInOrdem(Node n){
        // exibe todos os nós na forma ERD
        if (n == null)
            return;        
        visitInOrdem(n.left);
        n.showNo(); 
        visitInOrdem(n.right);        
    }
    
}
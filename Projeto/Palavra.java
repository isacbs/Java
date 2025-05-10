package Projeto;

/**
 * Classe que representa uma palavra, com seu texto, número de ocorrências e número de caracteres.
 * 
 * 
 * Desenvolvedoras:
 * 
 * @author Isadora Caetano Brandão de Sousa @ra 10420646
 * @author Luana Fernandes @ra 10439810
 */

public class Palavra {

    private String texto;
    private int ocorrencias;
    private int numeroCaracteres;
    private Palavra left, right, parent;

    /**
     * Construtor da classe Palavra.
     * 
     * @param texto, o texto da palavra.
     */
    public Palavra(String texto) {
        this.texto = texto.toLowerCase();
        this.ocorrencias = 1;
        this.numeroCaracteres = texto.length();
        this.left = null;
        this.right = null;
        this.parent = null;  
    }

    /**
     * 
     * Incrementa o número de ocorrências da palavra.
     * 
     */
    public void incrementarOcorrencias() {
        this.ocorrencias++;
    }

    /**
     * Retorna o texto da palavra.
     * 
     * @return o texto da palavra.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Retorna o número de ocorrências da palavra.
     * 
     * @return o número de ocorrências.
     */
    public int getOcorrencias() {
        return ocorrencias;
    }

    /**
     * Retorna o número de caracteres da palavra.
     * 
     * @return o número de caracteres.
     */
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }

    /**
     * Retorna o nó à esquerda da árvore.
     * 
     * @return o nó à esquerda.
     */
    public Palavra getLeft() {
        return left;
    }

    /**
     * Define o nó à esquerda da árvore.
     * 
     * @param left o nó à esquerda.
     */
    public void setLeft(Palavra left) {
        this.left = left;
    }

    /**
     * Retorna o nó à direita da árvore.
     * 
     * @return o nó à direita.
     */
    public Palavra getRight() {
        return right;
    }

    /**
     * Define o nó à direita da árvore.
     * 
     * @param right o nó à direita.
     */
    public void setRight(Palavra right) {
        this.right = right;
    }

    /**
     * Retorna o nó pai da árvore.
     * 
     * @return o nó pai.
     */
    public Palavra getParent() {
        return parent;
    }

    /**
     * Define o nó pai da árvore.
     * 
     * @param parent o nó pai.
     */
    public void setParent(Palavra parent) {
        this.parent = parent;
    }

    /**
     * Retorna uma representação em string da palavra e suas ocorrências.
     * 
     * @return a representação em string da palavra.
     */
    public String toString() {
        return texto + " (" + ocorrencias + " Ocorrências e " + numeroCaracteres + " Caracteres)";
    }
}
package Projeto;

import java.util.ArrayList;

/**
 * Classe que representa uma Árvore Binária de Busca (ABB) contendo instâncias da classe Palavra.
 * 
 * 
 * Desenvolvedoras:
 * 
 * @author Isadora Caetano Brandão de Sousa @ra 10420646
 * @author Luana Fernandes @ra 10439810
 */

public class ABB {

    private Palavra root;

    /**
     * 
     * Construtor da classe.
     * 
     */
    public ABB() {
        root = null;
    }

    /**
     * Verifica se a árvore está vazia.
     * 
     * @return true se a árvore estiver vazia, false caso contrário.
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Retorna o nó raiz da árvore.
     * 
     * @return raiz da árvore.
     */
    public Palavra root() {
        return root;
    }

    /**
     * Insere ou incrementa a ocorrência de uma palavra na árvore.
     * 
     * @param palavra.
     */
    public void incrementar(String pal) {
        Palavra nova = new Palavra(pal);
        Palavra y = null;
        Palavra x = root;

        while (x != null) {
            y = x;
            int m = nova.getTexto().compareTo(x.getTexto());
            if (m == 0) {
                x.incrementarOcorrencias();
                return;
            } else if (m < 0) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }

        if (y == null) {
            root = nova;
        } else if (nova.getTexto().compareTo(y.getTexto()) < 0) {
            y.setLeft(nova);
            nova.setParent(y);
        } else {
            y.setRight(nova);
            nova.setParent(y);
        }
    }

    /**
     * Busca por uma palavra específica na árvore.
     * 
     * @param palavra.
     * @return a palavra encontrada ou null se não existir.
     */
    public Palavra buscar(String pal) {
        Palavra atual = root;
        pal = pal.toLowerCase();
        while (atual != null) {
            int p = pal.compareTo(atual.getTexto());
            if (p == 0) {
                return atual;
            } else if (p < 0) {
                atual = atual.getLeft();
            } else {
                atual = atual.getRight();
            }
        }
        return null;
    }

    /**
     * Realiza a busca em ordem alfabética de todas as palavras na árvore.
     * 
     * @return uma lista de palavras na árvore em ordem alfabética.
     */
    public ArrayList<Palavra> emOrdem() {
        ArrayList<Palavra> lista = new ArrayList<>();
        executaInOrdem(root, lista);
        return lista;
    }

    private void executaInOrdem(Palavra no, ArrayList<Palavra> lista) {
        if (no != null) {
        	executaInOrdem(no.getLeft(), lista);
            lista.add(no);
            executaInOrdem(no.getRight(), lista);
        }
    }

    /**
     * Realiza a busca em ordem reversa de todas as palavras na árvore.
     * 
     * @return uma lista de palavras na árvore em ordem reversa.
     */
    public ArrayList<Palavra> reverso() {
        ArrayList<Palavra> lista = new ArrayList<>();
        reverso(root, lista);
        return lista;
    }

    private void reverso(Palavra no, ArrayList<Palavra> lista) {
        if (no != null) {
            reverso(no.getRight(), lista);
            lista.add(no);
            reverso(no.getLeft(), lista);
        }
    }

    /**
     * Realiza a busca por palavras que contenham uma parte da palavra fornecida.
     * 
     * @param parte da palavra.
     * @return uma lista de palavras que contêm a parte fornecida.
     */
    public ArrayList<Palavra> buscaPorParte(String parte) {
        parte = parte.toLowerCase();
        ArrayList<Palavra> resultado = new ArrayList<>();
        for (Palavra p : emOrdem()) {
            if (p.getTexto().contains(parte)) {
                resultado.add(p);
            }
        }
        return resultado;
    } 
}
package Projeto;

import java.util.ArrayList;

public class Vetor {
    private ArrayList<Atleta> atletas;
    private int maxAtletas;

    public Vetor(int maxAtletas) {
        this.atletas = new ArrayList<>(maxAtletas);
        this.maxAtletas = maxAtletas;
    }

    // Verifica se a lista está vazia
    public boolean isEmpty() {
        return atletas.isEmpty();
    }

    // Retorna a quantidade de atletas na lista
    public int size() {
        return atletas.size();
    }

    // Retorna o atleta da posição p
    public Atleta get(int p) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= atletas.size()) {
            throw new Exception("Posição inválida");
        }
        return atletas.get(p);
    }

    // Substitui o conteúdo de p por um novo atleta
    public void set(int p, Atleta novo) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= atletas.size()) {
            throw new Exception("Posição inválida");
        }
        atletas.set(p, novo);
    }

    // Adiciona um novo atleta à lista, mantendo o limite de maxAtletas
    // E também verifica se o atleta já existe na lista, para atualizar sua pontuação
    public void adicionarAtleta(Atleta atleta) {
        if (atleta == null) return;
        for (int i = 0; i < atletas.size(); i++) {
            Atleta a = atletas.get(i);
            if (a.getNome().equals(atleta.getNome()) && a.getPais().equals(atleta.getPais())) {
                a.setPontuacao(atleta.getPontuacao());
                ordenar(); 
                return;
            }
        }
        if (atletas.size() < maxAtletas) {
            atletas.add(atleta);
            ordenar(); 
        }
    }

    // Adiciona uma lista de atletas individualmente, mantendo o limite de maxAtletas
    public void adicionarAtletas(ArrayList<Atleta> novosAtletas) {
        for (Atleta atleta : novosAtletas) {
            if (atletas.size() >= maxAtletas) {
                break;
            }
            adicionarAtleta(atleta);
        }
    }

    // Remove o atleta da posição p
    public void remove(int p) throws Exception {
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= atletas.size()) {
            throw new Exception("Posição inválida!");
        }
        atletas.remove(p);
    }

    // Busca um atleta pelo nome e país
    public int search(Atleta busca) {
        for (int i = 0; i < atletas.size(); i++) {
            if (atletas.get(i).getNome().equals(busca.getNome()) &&
                atletas.get(i).getPais().equals(busca.getPais())) {
                return i;
            }
        }
        return -1; 
    }

    // Exibe todos os atletas da lista
    public void exibirLista() {
        for (Atleta atleta : atletas) {
            System.out.println(atleta);
        }
    }

    // Ordena a lista de atletas por pontuação 
    // Método de ordenação: BubbleSort
    public void ordenar() {
        int n = atletas.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (atletas.get(j).getPontuacao() < atletas.get(j + 1).getPontuacao()) {
                    Atleta temp = atletas.get(j);
                    atletas.set(j, atletas.get(j + 1));
                    atletas.set(j + 1, temp);
                }
            }
        }
    }

    // Retorna as 8 melhores atletas
    public ArrayList<Atleta> getFinalistas() {
        ArrayList<Atleta> finalistas = new ArrayList<>();
        int maxFinalistas = 8;
        for (int i = 0; i < atletas.size() && i < maxFinalistas; i++) {
            finalistas.add(atletas.get(i));
        }
        return finalistas;
    }

    // Retorna a lista completa de atletas
    public ArrayList<Atleta> getAtletas() {
        return atletas;
    }
}
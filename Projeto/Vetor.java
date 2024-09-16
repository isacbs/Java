package Projeto;

import java.util.ArrayList;

public class Vetor {
    private ArrayList<Atleta> atletas;
    private int maxAtletas;

    public Vetor(int maxAtletas) {
        this.atletas = new ArrayList<>(maxAtletas);
        this.maxAtletas = maxAtletas;
    }

    // Adicionar atleta na lista
    public void adicionarAtleta(Atleta atleta) {
        if (atleta == null) return;

        for (int i = 0; i < atletas.size(); i++) {
            Atleta a = atletas.get(i);
            if (a.getNome().equals(atleta.getNome()) && a.getPais().equals(atleta.getPais())) {
                // Atualiza a pontuação se o atleta já estiver na lista
                a.setPontuacao(atleta.getPontuacao());
                break;
            }
        }
            if (atletas.size() < maxAtletas) {
                atletas.add(atleta);
        }
        ordenar();
    }

    private void ordenar() {
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

    public void exibirLista() {
        for (Atleta atleta : atletas) {
            System.out.println(atleta);
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

    public ArrayList<Atleta> getAtletas() {
        return atletas;
    }
}
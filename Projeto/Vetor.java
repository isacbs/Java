
package Projeto;

public class Vetor {
    private Atleta[] atletas;
    private int maxAtletas;
    private int count;

    public Vetor(int maxAtletas) {
        this.atletas = new Atleta[maxAtletas];
        this.maxAtletas = maxAtletas;
        this.count = 0;
    }

    public boolean isEmpty() { // Verifica se a lista está vazia
        return count == 0;
    }

    public int size() { // Retorna a quantidade de atletas na lista
        return count;
    }

    public Atleta get(int p) throws Exception { // Retorna o atleta da posição p
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= count) {
            throw new Exception("Posição inválida");
        }
        return atletas[p];
    }

    public void set(int p, Atleta novo) throws Exception { // Substitui o conteúdo de p por um novo atleta
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= count) {
            throw new Exception("Posição inválida");
        }
        atletas[p] = novo;
    }

    public void adicionarAtleta(Atleta atleta) { // Adiciona um novo atleta à lista, mantendo o limite de maxAtletas
        										// também verifica se o atleta já existe na lista, para atualizar sua pontuação
        if (atleta == null) return;
        
        for (int i = 0; i < count; i++) { // Atualiza a pontuação se o atleta já existir
            Atleta a = atletas[i];
            if (a.getNome().equals(atleta.getNome()) && a.getPais().equals(atleta.getPais())) {
                a.setPontuacao(atleta.getPontuacao());
                ordenar();
                return;
            }
        }
        
        if (count < maxAtletas) { // Adiciona novo atleta se não houver espaço
            atletas[count] = atleta;
            count++;
            ordenar();
        }
    }

    public void adicionarAtletas(Atleta[] novosAtletas) {  // Adiciona uma lista de atletas individualmente, mantendo o limite de maxAtletas
        for (Atleta atleta : novosAtletas) {
            if (count >= maxAtletas) {
                break;
            }
            adicionarAtleta(atleta);
        }
    }

    public void remove(int p) throws Exception { // Remove o atleta da posição p
        if (isEmpty()) {
            throw new Exception("A lista está vazia!");
        }
        if (p < 0 || p >= count) {
            throw new Exception("Posição inválida!");
        }
        for (int i = p; i < count - 1; i++) {
            atletas[i] = atletas[i + 1];
        }
        atletas[count - 1] = null; 
        count--;
    }

    public int search(Atleta busca) { // Busca um atleta pelo nome e país
        for (int i = 0; i < count; i++) {
            if (atletas[i].getNome().equals(busca.getNome()) &&
                atletas[i].getPais().equals(busca.getPais())) {
                return i;
            }
        }
        return -1; 
    }

    public void exibirLista() { // Exibe todos os atletas da lista
        for (int i = 0; i < count; i++) {
            System.out.println(atletas[i]);
        }
    }

    public void ordenar() { // Ordena a lista de atletas por pontuação e método de ordenação: BubbleSort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (atletas[j].getPontuacao() < atletas[j + 1].getPontuacao()) {
                    Atleta temp = atletas[j];
                    atletas[j] = atletas[j + 1];
                    atletas[j + 1] = temp;
                }
            }
        }
    }
    
    public Atleta[] getFinalistas() { // Retorna as 8 melhores atletas
        int maxFinalistas = Math.min(8, count);
        Atleta[] finalistas = new Atleta[maxFinalistas];
        for (int i = 0; i < maxFinalistas; i++) {
            finalistas[i] = atletas[i];
        }
        return finalistas;
    }

    public Atleta[] getAtletas() { // Retorna a lista completa de atletas
        return atletas;
    }     
}
package Lab;

public class Main {
    public static void main(String[] args) throws Exception {
        // Representação do labirinto: # = parede, ' ' = caminho, Q = queijo e R = rato
        char[][] labirinto = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'Q', ' ', '#', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', ' ', ' ', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', ' ', '#', '#', ' ', '#', ' ', ' ', '#'},
            {'#', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', ' ', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', 'R', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        Labirinto lab = new Labirinto(labirinto, 100);

        int linInicial = 11; // Linha inicial do rato
        int colInicial = 1; // Coluna inicial do rato

        if (lab.walk(linInicial, colInicial)) 
            lab.exibir();
        else 
            System.out.println("O rato não conseguiu encontrar o queijo.");
    }
} 
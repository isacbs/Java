package Lab;

public class Labirinto {
    private Pilha pilha;
    private char[][] labirinto;
    private boolean[][] percorrer;
    private int linQ;
    private int colQ;
    private Lista rotaCerta; 

    public Labirinto(char[][] labirinto, int p) {
        this.labirinto = labirinto;
        this.pilha = new Pilha(p);
        this.percorrer = new boolean[labirinto.length][labirinto[0].length];
        this.rotaCerta = new Lista(p);
        discover();
    }

    // Encontra a posição do queijo
    private void discover() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++) {
                if (labirinto[i][j] == 'Q') {
                    linQ = i;
                    colQ = j;
                    return;
                }
            }
        }
    }

    // Move o rato pelo labirinto
    public boolean walk(int linha, int coluna) throws Exception {
        if (linha == linQ && coluna == colQ) {
        	rotaCerta.add(linha * labirinto[0].length + coluna);
            return true;
        }
       
        // Marca a posição como visitada e armazena o caminho atual realizado pelo rato
        percorrer[linha][coluna] = true; 
        rotaCerta.add(linha * labirinto[0].length + coluna);

        // Direções: baixo, cima, direita, esquerda
        int[][] sentidos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] s : sentidos) {
            int novaLinha = linha + s[0];
            int novaColuna = coluna + s[1];

            if (moveTrue(novaLinha, novaColuna)) {
                pilha.push(novaLinha * labirinto[0].length + novaColuna);
                
                if (walk(novaLinha, novaColuna)) 
                    return true;
                
                pilha.pop();
            }
        }        
        rotaCerta.remove(); 
        return false;
    }

    // Verifica se a movimentação realizada pelo rato é válida
    private boolean moveTrue(int linha, int coluna) {
        if (linha < 0 || linha >= labirinto.length || coluna < 0 || coluna >= labirinto[0].length)
            return false; 
        
        if (labirinto[linha][coluna] == '#' || percorrer[linha][coluna])
            return false;
        
        return true;
    }

    // Exibe a matriz final com o caminho correto marcando o caminho correto com 'x'
    public void exibir() throws Exception {
    	for (int i = 0; i < rotaCerta.size(); i++) {
            int pos = rotaCerta.get(i);
            int linha = pos / labirinto[0].length;
            int coluna = pos % labirinto[0].length; 

            if (labirinto[linha][coluna] != 'Q' && labirinto[linha][coluna] != 'R') 
                labirinto[linha][coluna] = 'x';        
        }
    	
        System.out.println("Achou o queijo");
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[i].length; j++)
                System.out.print(labirinto[i][j] + " ");
            System.out.println();
        }
    }
}
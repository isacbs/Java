package Projeto;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

/**
 * Classe principal que executa o programa.
 * 
 * 
 * Desenvolvedoras:
 * 
 * @author Isadora Caetano Brandão de Sousa @ra 10420646
 * @author Luana Fernandes @ra 10439810
 * 
 * Link da apresentação:
 */
public class ProjABB {

    private ABB arvore = new ABB();
    private int totalPalavras = 0;
    private int totalLinhas = 0;
    
    /**
     * Método principal que instancia a classe e inicia o programa.
     * 
     * @param args.
     * @throws IOException se ocorrer erro ao ler o arquivo.
     */
    public static void main(String[] args) throws IOException {
        ProjABB abb = new ProjABB();
        abb.executar();
    }

    public void executar() throws IOException {
        Scanner ent = new Scanner(System.in);
        int op = 0;
        boolean text = false;

        do {
            System.out.println("\nBem-vindo ao programa de leitura de arquivo de músicas, esse programa lerá o arquivo txt"
                    + " e trará dados sobre o mesmo! \nEscolha uma das opções do menu abaixo: ");
            System.out.println("1. Carregar texto");
            System.out.println("2. Estatísticas");
            System.out.println("3. Busca por palavra");
            System.out.println("4. Busca por parte da palavra");
            System.out.println("5. Exibição do texto");
            System.out.println("6. As 5 palavras mais recorrentes na música");
            System.out.println("7. Encerrar");

            try {
                System.out.print("Escolha: ");
                op = Integer.parseInt(ent.nextLine());

                if (op != 1 && op != 7 && !text) {
                    System.out.println("Por favor, carregue o texto antes de usar essa funcionalidade.");
                    continue;
                }

                switch (op) {
                    case 1:
                        carregarTexto("medobobo.txt");
                        text = true; 
                        break;

                    case 2:
                        estatisticas();
                        break;

                    case 3:
                        System.out.print("Digite a palavra que você deseja buscar: ");
                        String palavraBuscada = ent.nextLine().trim();

                        validarPalavra(palavraBuscada);

                        Palavra resultado = arvore.buscar(palavraBuscada);
                        if (resultado != null) {
                            System.out.println(resultado);
                        } else {
                            System.out.println("Palavra não encontrada. \nEssa palavra não se encontra na letra da música!");
                        }
                        break;

                    case 4:
                        System.out.print("Digite parte de uma palavra: ");
                        String parte = ent.nextLine().trim();

                        validarPalavra(parte);

                        List<Palavra> resultados = arvore.buscaPorParte(parte);
                        if (resultados.isEmpty()) {
                            System.out.println("Nenhuma palavra encontrada. \nEssa parte da palavra não se encontra na letra da música!");
                        } else {
                            for (Palavra p : resultados) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Árvore em ordem alfabética reversa:");
                        List<Palavra> reversa = arvore.reverso();
                        for (Palavra p : reversa) {
                            System.out.println(p);
                        }
                        break;

                    case 6:
                        List<Palavra> todas = arvore.emOrdem();
                        todas.sort((p1, p2) -> Integer.compare(p2.getOcorrencias(), p1.getOcorrencias()));
                        System.out.println("As 5 palavras mais recorrentes na música:");
                        for (int i = 0; i < Math.min(5, todas.size()); i++) {
                            System.out.println(todas.get(i));
                        }
                        break;

                    case 7:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Erro!! \nPor favor, digite apenas números de 1 e 7.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Erro!! \nPor favor, digite apenas números de 1 a 7.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        } while (op != 7);

        ent.close();
    }

    /**
     * Valida se a palavra contém dígitos e lança exceção se houver.
     *
     * @param palavra.
     * @throws IllegalArgumentException se a palavra contiver números
     */
    public void validarPalavra(String palavra) {
        for (char c : palavra.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Erro!! Não digite números, apenas letras.");
            }
        }
    }

    /**
     * Carrega o conteúdo do arquivo de texto, inserindo cada palavra na árvore.
     * 
     * @param nome, o arquivo a ser carregado.
     * @throws IOException se ocorrer erro ao ler o arquivo.
     */
    public void carregarTexto(String nome) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(nome));
        String linha;
        totalLinhas = 0;
        totalPalavras = 0;

        while ((linha = br.readLine()) != null) {
            totalLinhas++;
            linha = linha.toLowerCase();
            String[] palavras = linha.split(" ");

            for (String palavra : palavras) {
                if (!palavra.isEmpty()) {
                    arvore.incrementar(palavra);
                    totalPalavras++;
                }
            }
        }
        br.close();
        System.out.println("TEXTO CARREGADO.");
    }

    /**
     * 
     * Exibe as estatísticas gerais do texto carregado.
     *
     */
    public void estatisticas() {
        List<Palavra> lista = arvore.emOrdem();
        int distintas = lista.size();
        int totalCaracteres = 0;
        for (Palavra p : lista) {
            totalCaracteres += p.getNumeroCaracteres() * p.getOcorrencias();
        }
        double media = (double) totalCaracteres / totalPalavras;
        double redundancia = (1 - ((double) distintas / totalPalavras)) * 100;

        System.out.println("Total de linhas: " + totalLinhas);
        System.out.println("Total de palavras: " + totalPalavras);
        System.out.println("Palavras distintas: " + distintas);
        System.out.printf("Média de caracteres por palavra: %.2f\n", media);
        System.out.printf("Taxa de redundância: %.2f%%\n", redundancia);
    } 
}
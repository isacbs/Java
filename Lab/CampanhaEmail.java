package Lab;

/**
 * Criação da subclasse específica para campanhas de email
 * 
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */
public class CampanhaEmail extends Campanha {
    private double abertura;
    private double cliques;

    public CampanhaEmail(double abertura, double cliques) {
        this.abertura = abertura;
        this.cliques = cliques;
    }

    /**
	 * Implementação dos métodos abstratos para configurar, executar, avaliar
	 * 
	 */
    @Override
    public void configurar() { 
        System.out.println("Configurando a campanha de e-mail. ");
    }

    @Override
    public void executar() {
        System.out.println("Executando a campanha de e-mail. ");
    }

    @Override
    public void avaliar() {
        System.out.println("Avaliando a campanha de e-mail. ");
    }
    
    /**
	 * Implementação dos atributos específicos da subclasse
	 * 
	 */
    @Override
    public void metricas() {
        System.out.println("\n--:: Métricas da campanha de e-mail ::-- ");
        System.out.println("Taxa de Abertura: " + abertura + "%");
        System.out.println("Taxa de Cliques: " + cliques + "%");
    }
    
}
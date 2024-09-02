package Lab;

/**
 * Criação da subclasse específica para campanhas de redes sociais
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */
public class CampanhaRedesSociais extends Campanha {
	private double curtidas;
	private double compartilhamentos;
	private double comentarios;

	public CampanhaRedesSociais(double curtidas, double compartilhamentos, double comentarios) {
		this.curtidas = curtidas;
		this.compartilhamentos = compartilhamentos;
		this.comentarios = comentarios;
	}

	/**
	 * Implementação dos métodos abstratos para configurar, executar, avaliar
	 * 
	 */
	@Override 
	public void configurar() {
		System.out.println("Configurando a campanha de redes sociais. ");
	}

	@Override
	public void executar() {
		System.out.println("Executando a campanha de redes sociais. ");
	}

	@Override
	public void avaliar() {
		System.out.println("Avaliando a campanha de redes sociais. ");
	}

	/**
	 * Implementação dos atributos específicos da subclasse
	 * 
	 */
	@Override
	public void metricas() {
		System.out.println("\n--:: Métricas da campanha de redes sociais ::-- ");
		System.out.println("Curtidas: " + curtidas);
		System.out.println("Compartilhamentos: " + compartilhamentos);
		System.out.println("Comentários: " + comentarios);
	}
	
}
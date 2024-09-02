package Lab;

/**
 * Criação da classe abstrata
 * 
 *  
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */
public abstract class Campanha {

	/**
	 * Método Construtor
	 * 
	 * 
	 */
	public Campanha() {
	}

	/**
	 * Métodos abstratos para configurar, executar, avaliar e 
	 * mostrar as métricas da campanha
	 * 
	 * 
	 */
	public abstract void configurar();

	public abstract void executar();

	public abstract void avaliar();

	public abstract void metricas();
	
}
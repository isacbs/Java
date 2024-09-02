package Lab;

/**
 * Criação para classe de teste 
 * 
 * 
 * @author Isadora Caetano Brandão de Sousa
 * @tia 10420646
 */ 
public class Main {
	public static void main(String[] args) {
		 /**
		 * Criação para uma campanha de redes sociais
		 * e uma campanha de email
		 * 
		 */
        Campanha campanhaSocial = new CampanhaRedesSociais(1503, 428, 769);
        campanhaSocial.configurar();
        campanhaSocial.executar();
        campanhaSocial.avaliar();
        campanhaSocial.metricas();
        
        System.out.println();

        Campanha campanhaEmail = new CampanhaEmail(13.0, 7.5);
        campanhaEmail.configurar();
        campanhaEmail.executar();
        campanhaEmail.avaliar();
        campanhaEmail.metricas();
	}

}

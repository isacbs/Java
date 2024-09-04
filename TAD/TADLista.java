package TAD;

public class TADLista {
	public static void main(String[] args) throws Exception{
        Lista nomes = new Lista(5);
        
        
        nomes.add(0, "Star Wars: Episode III – Revenge of the Sith");
        nomes.add(1, "Captain America: The Winter Soldier");
        nomes.add(2, "Barbie");
        nomes.add(3, "The Hunger Games: Catching Fire");
        nomes.add(4, "Little Women");
        
        nomes.set(4, "Swan Lake");
        nomes.remove(2);
        nomes.add(3,"The Notebook");
        nomes.mostraLista();
        String x = nomes.get(3);
        System.out.println("Conteúdo = " + x);
        int result = nomes.search("The Hunger Games: Catching Fire");
        if (result == -1)
            System.out.println("Não existe 'The Hunger Games: Catching Fire' na lista");
        else
            System.out.println("The Hunger Games: Catching Fire está na posição " + result);      
        
    }

}

package tadlista;

public class TADLista {
    public static void main(String[] args) throws Exception {
        Lista gamers = new Lista(10);

        gamers.add(new Gamer("Isadora", 840));
        gamers.add(new Gamer("Ana", 789));
        gamers.add(new Gamer("Deize", 325));
        gamers.add(new Gamer("Maria", 653));
        gamers.add(new Gamer("Vera", 641));

        
        System.out.println("Lista inicial dos scores:");
        gamers.mostraLista();

        
        System.out.println("Jogador em primeiro lugar: " + gamers.get(0));

      
        gamers.remove(3);

        
        System.out.println("Lista dos scores após remover o quarto jogador:");
        gamers.mostraLista();
    }
}

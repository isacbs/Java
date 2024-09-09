package tadlista;

public class TADLista {
    public static void main(String[] args) throws Exception {
        Lista gamers = new Lista(5);

        gamers.add(0, new Gamer("Isadora", 913));
        gamers.add(1, new Gamer("Ana", 789));
        gamers.add(2, new Gamer("Deize", 325));
        gamers.add(3, new Gamer("Maria", 656));
        gamers.add(4, new Gamer("Vera", 641));

        gamers.set(4, new Gamer("Diana", 694));
        gamers.remove(2);
        gamers.add(3, new Gamer("Allie", 892));
        gamers.mostraLista();

        Gamer x = gamers.get(1);
        System.out.println("Conteúdo = " + x);

        int result = gamers.search(new Gamer("Maria", 656));
        if (result == -1) {
            System.out.println("Não existe 'Maria' na lista");
        } else {
            System.out.println("Maria está na posição " + result);
        }
    } 
}

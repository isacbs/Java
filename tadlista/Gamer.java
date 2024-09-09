package tadlista;

public class Gamer {
    private String name;
    private int score;

    public Gamer(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }

 // Compara nome e score
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (!(obj instanceof Gamer)) return false; 
        Gamer gamer = (Gamer) obj;
        return this.name.equals(gamer.name) && this.score == gamer.score; 
    }
    
}

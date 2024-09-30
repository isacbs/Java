package Lab;

import java.util.Comparator;

public class ComparadorPorPontuacao implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return Double.compare(a2.getPontuacao(), a1.getPontuacao());
    }
}
package Lab;

import java.util.Comparator;

public class ComparadorPorNome implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return a1.getNome().compareTo(a2.getNome());
    }
}
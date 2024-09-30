package Lab;

import java.util.Comparator;

public class ComparadorPorIdade implements Comparator<Atleta> {
    @Override
    public int compare(Atleta a1, Atleta a2) {
        return Integer.compare(a1.getIdade(), a2.getIdade());
    }
}
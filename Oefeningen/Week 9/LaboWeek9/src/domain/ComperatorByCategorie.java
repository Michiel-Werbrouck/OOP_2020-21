package domain;

import java.util.Comparator;

public class ComperatorByCategorie implements Comparator<Opdracht> {
    @Override
    public int compare(Opdracht o1, Opdracht o2) {
        if (o1 == null || o2 == null) return 1;

        int res = o1.getCategorie().compareTo(o2.getCategorie());
        if (res != 0)
            return res;

        return 1;
    }
}

package domain;

import java.util.Comparator;

public class Sortbyscore implements Comparator<DeelnemerGroep> {
    @Override
    public int compare(DeelnemerGroep o1, DeelnemerGroep o2) {
        if (o1 == null || o2 == null)
            return 0;

        return o1.getScore(o1.getWinnaar()) - o2.getScore(o2.getWinnaar());
    }
}

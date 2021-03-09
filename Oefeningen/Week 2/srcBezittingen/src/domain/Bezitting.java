package domain;

public class Bezitting {
    private Euro waarde;

    public Bezitting(Euro waarde){
        if (waarde == null || waarde.isNegatief())
            throw new IllegalArgumentException();
        this.waarde = waarde;
    }

    public Euro getWaarde() {
        return waarde;
    }
}

package domain;

public class Hond extends Bezitting{
    private String naam;
    private int gramVoedingPerDag;

    public Hond(String naam, Euro waarde, int gramVoedingPerDag){
        super(waarde);
        if (gramVoedingPerDag <= 0) throw new IllegalArgumentException();
        this.naam = naam;
        this.gramVoedingPerDag = gramVoedingPerDag;
    }

    public int getGramVoedingPerDag() {
        return gramVoedingPerDag;
    }
}

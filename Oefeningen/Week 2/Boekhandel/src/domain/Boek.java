package domain;

public class Boek extends Exemplaar{

    private int editie;

    public Boek(String titel, Euro prijs, int aantalStuks, int editie) {
        super(titel, prijs, aantalStuks);
        this.editie = editie;
    }
}

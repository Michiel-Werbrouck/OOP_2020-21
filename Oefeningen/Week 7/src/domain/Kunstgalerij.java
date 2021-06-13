package domain;

import java.util.ArrayList;

public class Kunstgalerij {
    private final String naam;
    private final ArrayList<Kunstwerk> collectie;

    public Kunstgalerij(String naam, ArrayList<Kunstwerk> collectie) {
        this.naam = naam;
        this.collectie = collectie;
    }

    public boolean voegKunstwerkToe(Kunstwerk kunstwerk) {
        if (kunstwerk == null || collectie.contains(kunstwerk)) return false;
        collectie.add(kunstwerk);
        return true;
    }

    public ArrayList<Kunstwerk> lijstUitleenbare() {
        ArrayList<Kunstwerk> uitleenbaar = new ArrayList<>();

        for (Kunstwerk kunstwerk : collectie) {
            if (kunstwerk.isUitleenbaar()) uitleenbaar.add(kunstwerk);
        }

        return uitleenbaar;
    }

    public ArrayList<Kunstwerk> lijstVerkoopbaar() {
        ArrayList<Kunstwerk> verkoopbaar = new ArrayList<>();

        for (Kunstwerk kunstwerk : collectie) {
            if (kunstwerk instanceof Verkoopbaar && !kunstwerk.isVerkocht()) verkoopbaar.add(kunstwerk);
        }

        return verkoopbaar;
    }

    public ArrayList<Kunstwerk> lijstNaVerwijderenUitvoerder(String uitvoerder) {
        ArrayList<Kunstwerk> verwijderd = new ArrayList<>();

        for (Kunstwerk kunstwerk : collectie) {
            if (kunstwerk.getUitvoerder().equals(uitvoerder)) {
                collectie.remove(kunstwerk);
                verwijderd.add(kunstwerk);
            }
        }

        return verwijderd;
    }

}

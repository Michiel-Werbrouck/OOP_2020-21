package domain;

import java.util.ArrayList;

public class Boekhandel {

    private ArrayList<Exemplaar> assortiment;

    public Boekhandel() {
        assortiment = new ArrayList<>();
    }

    public void voegExemplaarToe(Exemplaar e){
        if (e == null) throw new IllegalArgumentException();
        this.assortiment.add(e);
    }

    public void verwijderExemplaar(Exemplaar e) {
        if (e == null || !assortiment.contains(e)) throw new IllegalArgumentException();
        assortiment.remove(e);
    }

    public void veranderAantal(Exemplaar e, int aantal) {
        if (e == null || !assortiment.contains(e)) throw new IllegalArgumentException();
        int index = assortiment.indexOf(e);
        int vorigAantal = assortiment.get(index).getAantalStuks();
        assortiment.get(index).setAantalStuks(vorigAantal + aantal);
    }

    public ArrayList<Exemplaar> getAssortiment() {
        return assortiment;
    }
}

package domain;

import java.util.ArrayList;

public class Geschenkdoos {
    private ArrayList<Geschenk> geschenken;
    private Persoon schenker;
    private Persoon ontvanger;

    public Geschenkdoos(Persoon schenker, Persoon ontvanger, Geschenk geschenk) {
        if (schenker == null || ontvanger == null || geschenk == null) throw new IllegalArgumentException("Er mogen geen null waardes meegegeven worden.");
        if (schenker.equals(ontvanger)) throw new IllegalArgumentException("Schenker mag niet gelijk zijn aan ontvanger.");

        this.schenker = schenker;
        this.ontvanger = ontvanger;
        this.geschenken = new ArrayList<>();

        voegGeschenkToe(geschenk);
    }

    public void voegGeschenkToe(Geschenk geschenk) {
        if (geschenk == null) throw new IllegalArgumentException("Geschenk mag niet leeg zijn");
        if (geschenk instanceof KanVervallen && isVervallen(geschenk)) throw new IllegalArgumentException("Geschenk is vervallen.");
        if (geschenk instanceof HeeftMinimumLeeftijd && !isMinimumLeeftijd(geschenk)) throw new IllegalArgumentException("Ontvanger is niet oud genoeg.");
        geschenken.add(geschenk);
    }

    public Euro totalePrijs() {
        Euro prijs = new Euro(0, 0);

        for (Geschenk geschenk : geschenken) {
            prijs = prijs.som(geschenk.getPrijs());
        }

        return prijs;
    }

    private boolean isVervallen(Geschenk geschenk) {
        return ((KanVervallen) geschenk).isVervallen();
    }

    private boolean isMinimumLeeftijd(Geschenk geschenk) {
        if (ontvanger.getLeeftijd() > ((HeeftMinimumLeeftijd) geschenk).getMinimumAge()) return true;
        return false;
    }

    public ArrayList<Geschenk> getGeschenken() {
        return geschenken;
    }

    public Persoon getSchenker() {
        return schenker;
    }

    public Persoon getOntvanger() {
        return ontvanger;
    }

    @Override
    public String toString() {
        return "Geschenkdoos{" +
                "geschenken=" + geschenken +
                ", schenker=" + schenker +
                ", ontvanger=" + ontvanger +
                '}';
    }
}

package domain;

import java.util.ArrayList;
import java.util.Collection;

public class Residentie {

    private String naam, adres;
    private int aantalVerdiepingen;
    private ArrayList<Verblijf> verblijven;

    public Residentie(String naam, String adres, int aantalVerdiepingen) {
        if (naam == null || adres == null) throw new IllegalArgumentException("String waardes mogen niet null zijn.");
        if (naam.trim().isEmpty() || adres.trim().isEmpty()) throw new IllegalArgumentException("String waardes mogen niet leeg zijn.");

        this.naam = naam;
        this.adres = adres;
        this.aantalVerdiepingen = aantalVerdiepingen;
        verblijven = new ArrayList<>();
    }

    public Verblijf voegVerblijfToe(Verblijf verblijf) {
        if (verblijf == null) throw new IllegalArgumentException("Verblijf mag niet null zijn.");
        this.verblijven.add(verblijf);
        return verblijf;
    }

    public int aantalVrijeVerblijven() {
        int count = 0;

        for (Verblijf verblijf : verblijven) {
            if (!verblijf.getVerhuurStatus()) count++;
        }

        return count;
    }

    public ArrayList<Verblijf> verblijvenOnbetaaldeGemeentebelasting() {
        ArrayList<Verblijf> onbetaaldeCollectie = new ArrayList<>();

        for (Verblijf verblijf : verblijven) {
            if (verblijf instanceof StudentenVerblijf) {
                if (!((StudentenVerblijf)verblijf).isGemeentebelastingBetaald()) onbetaaldeCollectie.add(verblijf);
            }
        }

        return onbetaaldeCollectie;
    }

    public Euro totalePrijs() {
        Euro totaal = new Euro(0,0);

        for (Verblijf verblijf : verblijven) {
            totaal.som(verblijf.prijs());
        }

        return  totaal;
    }

    @Override
    public String toString() {
        return "Residentie " + naam + ":\n"
                + adres + "\n"
                + "Nog vrij: " + aantalVrijeVerblijven() + " verblijven";
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public int getAantalVerdiepingen() {
        return aantalVerdiepingen - 1;
    }
}

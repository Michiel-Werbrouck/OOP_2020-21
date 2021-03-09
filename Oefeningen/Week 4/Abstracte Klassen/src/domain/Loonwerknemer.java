package domain;

public class Loonwerknemer extends Werknemer {

    private int vastBedrag;
    private String prestatie;

    public Loonwerknemer(String naam, String voornaam, String rijksregisternummer) {
        super(naam, voornaam, rijksregisternummer);
    }

    public Loonwerknemer(String naam, String voornaam, String rijksregisternummer, String prestatie, int vastBedrag) {
        super(naam, voornaam, rijksregisternummer);

        if (prestatie.trim().isEmpty()) throw new IllegalArgumentException("Prestatie mag niet leeg zijn.");
        if (vastBedrag < 20) throw new IllegalArgumentException("Minimaal bedrag voor geleverde prestatie moet minimaal 20 zijn.");
        this.vastBedrag = vastBedrag;
        this.prestatie = prestatie;
    }

    public int getVastBedrag() {
        return vastBedrag;
    }

    public String getPrestatie() {
        return prestatie;
    }

    @Override
    public int verloning() {
       return 10 * getAantalGewerkteUren() + vastBedrag;
    }
}

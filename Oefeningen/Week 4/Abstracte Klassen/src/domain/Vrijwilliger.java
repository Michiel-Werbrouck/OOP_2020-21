package domain;

public class Vrijwilliger extends Werknemer{

    public Vrijwilliger(String naam, String voornaam, String rijksregisternummer) {
        super(naam, voornaam, rijksregisternummer);
    }

    @Override
    public int verloning() {
        return 2 * getAantalGewerkteUren();
    }
}

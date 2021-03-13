package domain;

public class Speelgoed implements Geschenk{

    private Euro prijs;
    private String naam, firmanaam;

    public Speelgoed(Euro prijs, String naam, String firmanaam) {
        if (prijs == null || naam.trim().isEmpty() || firmanaam.trim().isEmpty())
            throw new IllegalArgumentException("Geen lege/null waardes");

        this.prijs = prijs;
        this.naam = naam;
        this.firmanaam = firmanaam;
    }

    @Override
    public Euro getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return "Speelgoed{" +
                "prijs=" + prijs +
                ", naam='" + naam + '\'' +
                ", firmanaam='" + firmanaam + '\'' +
                '}';
    }
}

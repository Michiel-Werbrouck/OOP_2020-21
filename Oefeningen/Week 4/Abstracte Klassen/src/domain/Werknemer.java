package domain;

public abstract class Werknemer {
    private String naam, voornaam, rijksregisternummer;
    private int aantalGewerkteUren;

    public Werknemer(String naam, String voornaam, String rijksregisternummer) {
        if (naam.trim().isEmpty() || voornaam.trim().isEmpty() || rijksregisternummer.trim().isEmpty())
            throw new IllegalArgumentException("Velden mogen niet leeg zijn.");

        if (!rijksregisternummer.matches("\\d{2}.\\d{2}.\\d{2}-\\d{3}.\\d{2}"))
            throw new IllegalArgumentException("Rijksregisternummer moet formaat respecteren.");

        this.naam = naam;
        this.voornaam = voornaam;
        this.rijksregisternummer = rijksregisternummer;
    }

    public abstract int verloning();

    public void resetAantalUren() {
        aantalGewerkteUren = 0;
    }

    public void veranderUren(int aantal) {
        aantalGewerkteUren += aantal;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getRijksregisternummer() {
        return rijksregisternummer;
    }

    public int getAantalGewerkteUren() {
        return aantalGewerkteUren;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + this.naam + " (" + this.rijksregisternummer + ")\n"
                + "Verloning: " + verloning() + "\n"
                + "Aantal uren gewerkt (nog niet betaald): " + this.aantalGewerkteUren;
    }
}

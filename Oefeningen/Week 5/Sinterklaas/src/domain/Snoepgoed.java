package domain;

import java.time.LocalDate;

public class Snoepgoed implements Geschenk, KanVervallen{

    private Euro prijs;
    private String naam;
    private LocalDate vervaldatum;

    public Snoepgoed(Euro prijs, String naam, LocalDate vervaldatum) {
        if (prijs == null || naam.trim().isEmpty() || vervaldatum == null)
            throw new IllegalArgumentException("Geen lege/null waardes");

        this.prijs = prijs;
        this.naam = naam;
        this.vervaldatum = vervaldatum;
    }

    public String getNaam() {
        return naam;
    }

    @Override
    public LocalDate getVervaldatum() {
        return vervaldatum;
    }

    @Override
    public boolean isVervallen() {
        return LocalDate.now().isAfter(vervaldatum);
    }

    @Override
    public Euro getPrijs() {
        return prijs;
    }

    @Override
    public String toString() {
        return "Snoepgoed{" +
                "prijs=" + prijs +
                ", naam='" + naam + '\'' +
                ", vervaldatum=" + vervaldatum +
                '}';
    }
}

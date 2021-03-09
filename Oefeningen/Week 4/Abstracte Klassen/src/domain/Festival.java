package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Festival {
    private String naam;
    private LocalDate startdatum, einddatum;

    private ArrayList<Werknemer> werknemers;
    private ArrayList<Optreden> optredens;

    public Festival(String naam, LocalDate startdatum, LocalDate einddatum) {
        if (naam.trim().isEmpty()) throw new IllegalArgumentException("Naam mag niet leeg zijn.");
        if (einddatum.isBefore(startdatum))
            throw new IllegalArgumentException("Einddatum mag niet voor begindatum zijn.");

        this.naam = naam;
        this.startdatum = startdatum;
        this.einddatum = einddatum;

        werknemers = new ArrayList<>();
        optredens = new ArrayList<>();
    }

    public void addWerknemer(Werknemer werknemer) {
        if (werknemer == null) throw new IllegalArgumentException("Werknemer mag niet null zijn.");

        werknemers.add(werknemer);
    }

    public int aantalBonnenNodig() {
        int count = 0;

        for (Werknemer werknemer : werknemers) {
            if (werknemer instanceof Vrijwilliger) {
                count += werknemer.verloning();
            }
        }

        return count;
    }

    public ArrayList<String> getPrestaties() {
        ArrayList<String> prestaties = new ArrayList<>();
        for (Werknemer werknemer : werknemers) {
            if (werknemer instanceof Loonwerknemer) {
                prestaties.add(((Loonwerknemer) werknemer).getPrestatie());
            }
        }

        return prestaties;
    }

    public int gemiddeldVastBedrag() {
        int count = 0;
        int amount = 0;

        for (Werknemer werknemer : werknemers) {
            if (werknemer instanceof Loonwerknemer) {
                amount++;
                count += ((Loonwerknemer) werknemer).getVastBedrag();
            }
        }

        return count / amount;
    }

    public String getNaam() {
        return naam;
    }

    public LocalDate getStartdatum() {
        return startdatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public ArrayList<Werknemer> getWerknemers() {
        return werknemers;
    }

    public ArrayList<Optreden> getOptredens() {
        return optredens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Festival festival = (Festival) o;
        return Objects.equals(naam, festival.naam)
                && Objects.equals(startdatum, festival.startdatum)
                && Objects.equals(einddatum, festival.einddatum)
                && Objects.equals(werknemers, festival.werknemers)
                && Objects.equals(optredens, festival.optredens);
    }

    @Override
    public String toString() {
        return "Festival{" +
                "naam='" + naam + '\'' +
                ", startdatum=" + startdatum +
                ", einddatum=" + einddatum +
                ", werknemers=" + werknemers +
                ", optredens=" + optredens +
                '}';
    }
}

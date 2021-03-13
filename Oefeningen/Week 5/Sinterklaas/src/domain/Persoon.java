package domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Persoon {

    private String naam, voornaam;
    private LocalDate geboortedatum;

    public Persoon(String naam, String voornaam, LocalDate geboortedatum) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public int getLeeftijd() {
        return Period.between(geboortedatum, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoon persoon = (Persoon) o;
        return Objects.equals(naam, persoon.naam) && Objects.equals(voornaam, persoon.voornaam) && Objects.equals(geboortedatum, persoon.geboortedatum);
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                '}';
    }
}

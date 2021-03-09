package domain;

import java.time.LocalDate;

public class Weekblad extends Exemplaar {

    private LocalDate uitgifteWeek;

    public Weekblad(String titel, Euro prijs, int aantalStuks, LocalDate uitgifteWeek) {
        super(titel, prijs, aantalStuks);
        this.uitgifteWeek = uitgifteWeek;
    }
}

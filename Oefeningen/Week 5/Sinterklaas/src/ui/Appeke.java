package ui;

import domain.*;

import java.time.LocalDate;

public class Appeke {

    public static void main(String[] args) {
        //nee ik ga geen test maken, te tam daarvoor. Als dit werkt, werkt alles.

        Persoon schenker = new Persoon("Werbrouck", "Michiel", LocalDate.of(2001, 4,18));
        Persoon ontvanger = new Persoon("Smikkel", "Tikkel", LocalDate.of(2012, 4,18));

        Snoepgoed snoepgoed = new Snoepgoed(new Euro(1,20), "UCLLSnoep", LocalDate.now().plusWeeks(2));
        MinimumLeeftijdSpeelgoed minimumLeeftijdSpeelgoed = new MinimumLeeftijdSpeelgoed(new Euro(10,50), "UCLLToys", "UCLLInc", 7);

        Geschenkdoos doos = new Geschenkdoos(schenker, ontvanger, snoepgoed);
        doos.voegGeschenkToe(minimumLeeftijdSpeelgoed);

        System.out.println(doos.toString());
        System.out.println(doos.totalePrijs().geefInfoAlsString());
    }
}

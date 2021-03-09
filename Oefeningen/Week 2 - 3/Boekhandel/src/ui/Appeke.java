package ui;

import domain.*;

import java.time.LocalDate;

public class Appeke {

    public static void main(String[] args) {
        Boekhandel boekhandel = new Boekhandel();
        Boek boek = new Boek("UCLL", new Euro(5, 0), 10, 1);
        Weekblad weekblad = new Weekblad("UCLLblad", new Euro(5,0), 5, LocalDate.now());
        Cd cd = new Cd("coolePlaylist", new Euro(5,0), 5);

        boekhandel.voegExemplaarToe(boek);
        System.out.println(boekhandel.getAssortiment().size());
        boekhandel.voegExemplaarToe(weekblad);
        System.out.println(boekhandel.getAssortiment().size());
        boekhandel.voegExemplaarToe(cd);
        System.out.println(boekhandel.getAssortiment().size());

        boekhandel.verwijderExemplaar(boek);
        System.out.println(boekhandel.getAssortiment().size());
        boekhandel.voegExemplaarToe(boek);
        System.out.println(boekhandel.getAssortiment().size());

        int index = boekhandel.getAssortiment().indexOf(boek);

        System.out.println(boekhandel.getAssortiment().get(index).getAantalStuks());

        boekhandel.veranderAantal(boek, -2);

        System.out.println(boekhandel.getAssortiment().get(index).getAantalStuks());

    }
}

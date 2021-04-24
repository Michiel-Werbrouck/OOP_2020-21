package db;

import domain.Opdracht;

import java.util.ArrayList;

public class OpdrachtDatabank {

    ArrayList<Opdracht> opdrachten;
    private String fileName;

    public OpdrachtDatabank(String fileName) {
        this.fileName = fileName;
    }

    public void voegToe(Opdracht opdracht) {
        opdrachten.add(opdracht);
    }

    public ArrayList<Opdracht> getOpdrachten() {
        return opdrachten;
    }
}

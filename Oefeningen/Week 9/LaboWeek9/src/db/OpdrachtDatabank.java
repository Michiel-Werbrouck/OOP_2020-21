package db;

import domain.ComperatorByCategorie;
import domain.ComperatorById;
import domain.Opdracht;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class OpdrachtDatabank {

    private final ArrayList<Opdracht> opdrachten;

    public OpdrachtDatabank(String fileName) {
        if (fileName == null || fileName.trim().isEmpty())
            throw new IllegalArgumentException("Filename can't be empty.");

        this.opdrachten = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(fileName));

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                String[] subStrings = s.split("\\t");

                int id = Integer.parseInt(subStrings[0]);
                String vraag = subStrings[1];
                String antwoord = subStrings[2];
                boolean hoofdletterGevoelig = Boolean.parseBoolean(subStrings[3]);
                String hint = subStrings[4];
                String categorie = subStrings[5];
                String auteur = subStrings[6];

                Opdracht opdracht = new Opdracht(id, vraag, antwoord, hoofdletterGevoelig, hint, categorie, auteur);
                this.opdrachten.add(opdracht);
            }
        } catch (FileNotFoundException ex) {
            throw new IllegalArgumentException("kan bestand niet vinden");
        } catch (NumberFormatException e) {
            System.out.println("data niet numeriek");
        }
    }



    public void voegToe(Opdracht opdracht) {
        if (opdracht == null || this.opdrachten.contains(opdracht))
            throw new IllegalArgumentException("Opdracht kan niet leeg zijn.");

        this.opdrachten.add(opdracht);
    }

    public ArrayList<Opdracht> getOpdrachten() {
        return this.opdrachten;
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpCategorie() {
        this.opdrachten.sort(new ComperatorByCategorie());
        return this.opdrachten;
    }

    public ArrayList<Opdracht> getOpdrachtenGesorteerdOpCategorieEnId() {
        this.opdrachten.sort(new ComperatorByCategorie());
        this.opdrachten.sort(new ComperatorById());
        return this.opdrachten;
    }
}

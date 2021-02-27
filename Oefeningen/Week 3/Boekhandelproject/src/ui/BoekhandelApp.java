package ui;

import domain.*;

public class BoekhandelApp {
    public static void main(String[] args){
        Artikel knack = new Weekblad("knack weekend",new Euro(6,40),12);
        Artikel javascriptVoorDummies = new Boek("JS voor dummies",new Euro(25,40),2);
        Artikel libelle = new Weekblad("Libelle special koken",new Euro(7,25),20);
        /*knack.koop(25);
        knack.verkoop(20);

        libelle.koop(24);*/
        Artikel knack2 = new Weekblad("knack weekend",new Euro(6,40),12);

        Boekhandel opdehoek = new Boekhandel();
        opdehoek.voegArtikelToe(knack);
        opdehoek.voegArtikelToe(javascriptVoorDummies);
        opdehoek.voegArtikelToe(libelle);
        opdehoek.voegArtikelToe(knack2);
        opdehoek.koop(knack,25);
        opdehoek.verkoop(knack,20);
        opdehoek.koop(libelle,24);
        System.out.print(opdehoek.toString());
        opdehoek.verkoop(libelle,25);
        System.out.println("__________________________");
        System.out.print(opdehoek.toString());

    }
}

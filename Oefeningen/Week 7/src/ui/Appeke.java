package ui;

import domain.Beeldhouwwerk;
import domain.DomainException;
import domain.VerkoopbaarBeeldhouwwerk;

public class Appeke {
    public static void main(String[] args) throws DomainException {
        Beeldhouwwerk beeldhouwwerk = new Beeldhouwwerk("UCLL moment", "Serschat", 75.4, "turks");
        System.out.println(beeldhouwwerk);
    }
}

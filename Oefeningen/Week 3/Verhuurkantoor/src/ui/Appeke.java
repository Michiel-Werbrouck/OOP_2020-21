package ui;

import domain.Euro;
import domain.Residentie;
import domain.Studentenkamer;
import domain.Verblijf;

import java.util.ArrayList;

public class Appeke {

    public static void main(String[] args) {
        Residentie emilia = new Residentie("Emilia", "Waversebaan 27", 4);
        Studentenkamer seppeKamer = new Studentenkamer(1, 10, new Euro(10,0), 13);
        emilia.voegVerblijfToe(seppeKamer);
        ArrayList<Verblijf> onbetaaldCollectie = emilia.verblijvenOnbetaaldeGemeentebelasting();
        System.out.println(onbetaaldCollectie.size());
    }
}

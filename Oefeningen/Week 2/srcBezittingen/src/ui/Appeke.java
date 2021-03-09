package ui;

import domain.*;

public class Appeke {
    public static void main(String[] args){
        Bezitting schilderij = new Schilderij("DD","hsjkhd",new Euro(1500,0));
        Bezitting hond = new Hond("jsljfsl",new Euro(50,0),125);
        Bezitting wagen = new Wagen("fsjfsl",4500,new Euro(25000,25));

        Persoon p = new Persoon();
        p.voegBezittingToe(schilderij);
        p.voegBezittingToe(hond);
        p.voegBezittingToe(wagen);

        System.out.println(p.totaleWaarde().geefInfoAlsString());
        System.out.println(((Hond)hond).getGramVoedingPerDag());
    }
}

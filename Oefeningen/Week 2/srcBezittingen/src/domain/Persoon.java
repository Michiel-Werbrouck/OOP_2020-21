package domain;

import java.util.ArrayList;

public class Persoon {
    private ArrayList<Bezitting> bezittingen;

    public Persoon() {
        this.bezittingen = new ArrayList<>();
    }

    public void voegBezittingToe(Bezitting b){
        if (b == null) throw new IllegalArgumentException();
        this.bezittingen.add(b);
    }

    public Euro totaleWaarde(){
        Euro totaal = new Euro(0,0);
        for (Bezitting b: this.bezittingen){
            totaal = totaal.som(b.getWaarde());
        }
        return totaal;
    }

    public int minimaleHoeveelHeidHondenVoedingPerDag(){
        int som = 0 ;
        for (Bezitting b: this.bezittingen){
            if (b instanceof Hond){
                som += ((Hond)b).getGramVoedingPerDag();
            }
        }
        return som;
    }

    public int minimaleHoeveelHeidHondenVoeding(int aantalDagen){
        if (aantalDagen < 0) throw new IllegalArgumentException();
        return this.minimaleHoeveelHeidHondenVoedingPerDag() * aantalDagen;
    }

    public boolean heeftSchilderijVanSchilder(String schilder){
        if (schilder == null) return false;
        for (Bezitting b: this.bezittingen){
            if (b instanceof Schilderij){
                if (schilder.equals(((Schilderij)b).getSchilder())) return true;
            }
        }
        return false;
    }

    public Wagen wagenMetGrootsteCylinderInhoud(){
        int grootste = 0;
        Wagen w = null;
        for (Bezitting b: this.bezittingen){
            if (b instanceof Wagen &&
                    ((Wagen)b).getCylinderinhoud() > grootste){
                w = (Wagen)b;
                grootste = w.getCylinderinhoud();
            }
        }
        return w;
    }


}

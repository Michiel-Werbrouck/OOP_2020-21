package domain;

import java.util.ArrayList;

public class Boekhandel {
    private ArrayList<Artikel> artikels;

    public Boekhandel(){
        this.artikels = new ArrayList<>();
    }

    public void voegArtikelToe(Artikel artikel){
        if (artikel == null) throw new IllegalArgumentException();
        boolean ok = false;
        for (int i = 0; i < this.artikels.size() && !ok; i++){
            if (artikels.get(i).equals(artikel)){
                artikels.get(i).koop();
                ok= true;
            }
        }

        if (!ok){
            this.artikels.add(artikel);
        }
    }

    public void koop(Artikel artikel, int aantalStuks){
        if (artikel == null) throw new IllegalArgumentException();
        boolean gevonden = false;
        for (int i = 0 ; i < this.artikels.size() && !gevonden;i++){
            if (artikels.get(i).equals(artikel)){
                gevonden = true;
                artikels.get(i).koop(aantalStuks);
            }
        }

        if (!gevonden) {
            artikel.koop(aantalStuks);
            this.voegArtikelToe(artikel);
        }
    }

    public void koop(Artikel artikel){
        this.koop(artikel,1);
    }

    public void verkoop(Artikel artikel, int aantalStuks){
        if (artikel == null) throw new IllegalArgumentException();
        boolean gevonden = false;
        for (int i = 0 ; i < this.artikels.size() && !gevonden;i++){
            if (artikels.get(i).equals(artikel)){
                gevonden = true;
                artikels.get(i).verkoop(aantalStuks);
                if (artikels.get(i).getAantalInVoorraad() == 0){
                    this.artikels.remove(i);
                }
            }
        }

        if (!gevonden) {
            throw new IllegalStateException("Artikel komt niet voor");
        }
    }

    public void verkoop(Artikel artikel){
        this.verkoop(artikel,1);
    }

    @Override
    public String toString(){
        String uit = "Mijn artikelen : \n";
        for (Artikel artikel: this.artikels){
            uit+= artikel.toString() + "\n";
        }
        return uit;
    }
}

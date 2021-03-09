package domain;

public class Artikel {
    private String titel;
    private Euro prijs;
    private int aantalInVoorraad;

    public Artikel(String titel, Euro prijs, int aantal) {
        if (aantal <= 0) throw new IllegalArgumentException();
        if (prijs == null) throw new IllegalArgumentException();
        if (titel == null) throw new IllegalArgumentException();
        this.titel = titel;
        this.prijs = prijs;
        this.aantalInVoorraad = aantal;
    }
    public Artikel(String titel, Euro prijs) {
        this(titel,prijs,1);
    }

    public void verkoop(){
        this.verkoop(1);
    }

    public int getAantalInVoorraad(){
        return this.aantalInVoorraad;
    }

    public void verkoop(int aantal){
        if (aantal <= 0) throw new IllegalArgumentException();
        if (this.aantalInVoorraad < aantal) throw new IllegalStateException();
        this.aantalInVoorraad-= aantal;
    }

    public void koop(){
        this.koop(1);
    }

    public void koop(int aantal){
        if (aantal <= 0) throw new IllegalArgumentException();
        this.aantalInVoorraad+= aantal;
    }

   @Override
   public boolean equals (Object o){
        return this.getClass() == o.getClass()
                && this.titel.equals(((Artikel)o).titel);
    }

    @Override
    public String toString(){
        return this.titel + "\nprijs= " + this.prijs.geefInfoAlsString() + "\nAantal in voorraad = " + this.aantalInVoorraad + "\n";
    }

}

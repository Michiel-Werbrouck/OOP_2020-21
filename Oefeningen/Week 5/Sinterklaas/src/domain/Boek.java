package domain;

public class Boek implements Geschenk, HeeftMinimumLeeftijd{

    private Euro prijs;
    private String titel, auteur;
    private int aantalPaginas;

    public Boek(Euro prijs, String titel, String auteur, int aantalPaginas) {

        if (aantalPaginas < 0) throw new IllegalArgumentException("Aantal pagin's mag niet negatief zijn.");
        //ben te lui om de andere te doen.

        this.prijs = prijs;
        this.titel = titel;
        this.auteur = auteur;
        this.aantalPaginas = aantalPaginas;
    }

    @Override
    public Euro getPrijs() {
        return null;
    }

    @Override
    public int getMinimumAge() {
        if (aantalPaginas >= 10)
            return 8 + (int)Math.floor(1 * aantalPaginas / 50);

        return 0;
    }

    @Override
    public String toString() {
        return "Boek{" +
                "prijs=" + prijs +
                ", titel='" + titel + '\'' +
                ", auteur='" + auteur + '\'' +
                ", aantalPaginas=" + aantalPaginas +
                '}';
    }
}

package domain;

public class Exemplaar {

    private String titel;
    private Euro prijs;
    private int aantalStuks;

    public Exemplaar(String titel, Euro prijs, int aantalStuks) {
        this.titel = titel;
        this.prijs = prijs;
        this.aantalStuks = aantalStuks;
    }

    public Euro getPrijs() {
        return prijs;
    }

    public String getTitel() {
        return titel;
    }

    public int getAantalStuks() {
        return aantalStuks;
    }

    public void setAantalStuks(int aantalStuks) {
        this.aantalStuks = aantalStuks;
    }
}

package domain;

public class Persoon {
    private String naam;
    private int leeftijd;

    public Persoon(String naam, int leeftijd) throws DomainException {
        if (!isValidNaam(naam) || !isValidLeeftijd(leeftijd)) throw new IllegalStateException();

        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public static boolean isValidNaam(String naam) throws DomainException {
        if (naam == null || naam.trim().isEmpty())
            throw new DomainException("Geen effectieve naam");

        return true;
    }

    public static boolean isValidLeeftijd(int leeftijd) throws DomainException {
        if (leeftijd < 10)
            throw new DomainException("Geen geldige leeftijd");

        return true;
    }

    @Override
    public String toString() {
        return this.naam;
    }

}

package domain;

public class Beeldhouwwerk extends Kunstwerk{
    private final double gewicht;
    private String materiaal;

    public Beeldhouwwerk(String titel, String uitvoerder, double gewicht, String materiaal) throws DomainException {
        super(titel, uitvoerder);

        if (gewicht < 0) throw new DomainException("");
        this.gewicht = gewicht;
    }

    @Override
    public boolean isUitleenbaar() {
        return gewicht < 15;
    }

    @Override
    public String toString() {
        return "Beeldhouwwerk{" +
                "gewicht=" + gewicht +
                ", materiaal='" + materiaal + '\'' +
                '}';
    }
}

package domain;

public class MinimumLeeftijdSpeelgoed extends Speelgoed implements HeeftMinimumLeeftijd{
    private int minimumLeeftijd;

    public MinimumLeeftijdSpeelgoed(Euro prijs, String naam, String firmanaam, int minimumLeeftijd) {
        super(prijs, naam, firmanaam);

        if (minimumLeeftijd < 0) throw new IllegalArgumentException("Minimum leeftijd mag niet negatief zijn.");
        this.minimumLeeftijd = minimumLeeftijd;
    }

    @Override
    public int getMinimumAge() {
        return minimumLeeftijd;
    }

    @Override
    public String toString() {
        return "MinimumLeeftijdSpeelgoed{" +
                "minimumLeeftijd=" + minimumLeeftijd +
                '}';
    }
}

package domain;

public class Appartement extends StudentenVerblijf {

    private int aantalKamers;

    public Appartement(int verdiepingnummer, int verblijfnummer, Euro prijsPerVierkanteMeter, int oppervlakte, int aantalKamers) {
        super(verdiepingnummer, verblijfnummer, prijsPerVierkanteMeter, oppervlakte);

        this.aantalKamers = aantalKamers;
    }

    @Override
    public Euro prijs() {
        if (aantalKamers < 3) return super.prijs();

        return super.prijs().som(new Euro(100 * (aantalKamers - 3),0));
    }
}

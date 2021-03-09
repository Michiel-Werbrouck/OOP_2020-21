package domain;

public class Studentenkamer extends StudentenVerblijf {

    public Studentenkamer(int verdiepingnummer, int verblijfnummer, Euro prijsPerVierkanteMeter, int oppervlakte) {
        super(verdiepingnummer, verblijfnummer, prijsPerVierkanteMeter, oppervlakte);
    }

    @Override
    public Euro prijs() {
        return super.prijs().produkt(getOppervlakte());
    }
}

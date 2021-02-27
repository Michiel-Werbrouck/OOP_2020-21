package domain;

public class Studio extends Verblijf {

    private int oppervlakteLeefruimte;
    private int oppervlakteBadkamer;

    public Studio(int verdiepingnummer, int verblijfnummer, Euro prijsPerVierkanteMeter, int oppervlakte, int oppervlakteLeefruimte, int grootteBadkamer) {
        super(verdiepingnummer, verblijfnummer, prijsPerVierkanteMeter, oppervlakte);

        this.oppervlakteLeefruimte = oppervlakteLeefruimte;
        this.oppervlakteBadkamer = grootteBadkamer;
    }

    @Override
    public Euro prijs() {
        return super.prijs().produkt(getOppervlakte()).som(super.prijs().produkt(2).produkt(oppervlakteBadkamer));
    }

    public int getOppervlakteBadkamer() {
        return oppervlakteBadkamer;
    }
}

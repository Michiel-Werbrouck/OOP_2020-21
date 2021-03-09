package domain;

public class StudentenVerblijf extends Verblijf{

    private boolean isGemeentebelastingBetaald;

    public StudentenVerblijf(int verdiepingnummer, int verblijfnummer, Euro prijsPerVierkanteMeter, int oppervlakte) {
        super(verdiepingnummer, verblijfnummer, prijsPerVierkanteMeter, oppervlakte);
    }

    public void setGemeentebelastingBetaald(boolean gemeentebelastingBetaald) {
        isGemeentebelastingBetaald = gemeentebelastingBetaald;
    }

    public boolean isGemeentebelastingBetaald() {
        return isGemeentebelastingBetaald;
    }
}

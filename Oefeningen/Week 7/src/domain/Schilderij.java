package domain;

public class Schilderij extends Kunstwerk implements Verkoopbaar {

    private final double hoogte;
    private final double breedte;
    private double waarde;

    public Schilderij(String titel, String uitvoerder, double hoogte, double breedte, double waarde) throws DomainException {
        super(titel, uitvoerder);

        if (hoogte < 0 || breedte < 0) throw new DomainException("");

        this.hoogte = hoogte;
        this.breedte = breedte;
        setWaarde(waarde);
    }

    public void setWaarde(double waarde) throws DomainException {
        if (waarde < 0) {
            throw new DomainException("");
        }

        this.waarde = waarde;
    }

    @Override
    public boolean isUitleenbaar() {
        return !isVerkocht() && this.hoogte < 150 && this.breedte < 150 ;
    }

    @Override
    public void setVerkocht() {
        this.isVerkocht = true;
    }

    @Override
    public double getPrijs() {
        return waarde * 1.10;
    }
}

package domain;

public class VerkoopbaarBeeldhouwwerk extends Beeldhouwwerk implements Verkoopbaar {

    private double waarde;

    public VerkoopbaarBeeldhouwwerk(String titel, String uitvoerder, double gewicht, String materiaal, double waarde) throws DomainException {
        super(titel, uitvoerder, gewicht, materiaal);

        if (waarde < 0) throw new DomainException("");
        this.waarde = waarde;
    }

    @Override
    public void setVerkocht() {
        this.isVerkocht = true;
    }

    @Override
    public double getPrijs() {
        return waarde * 1.15;
    }

    @Override
    public boolean isUitleenbaar() {
        return !isVerkocht() && super.isUitleenbaar();
    }

    @Override
    public String toString() {
        return "VerkoopbaarBeeldhouwwerk{" + super.toString() +
                "waarde=" + waarde +
                '}';
    }
}

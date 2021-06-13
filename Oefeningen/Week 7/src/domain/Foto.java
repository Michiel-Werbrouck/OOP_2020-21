package domain;

public class Foto extends Kunstwerk implements Verkoopbaar{
    private final boolean isZwartWit;

    public Foto(String titel, String uitvoerder, boolean isZwartWit) throws DomainException {
        super(titel, uitvoerder);

        this.isZwartWit = isZwartWit;
    }

    @Override
    public boolean isUitleenbaar() {
        return false;
    }

    @Override
    public void setVerkocht() {
        this.isVerkocht = true;
    }

    @Override
    public double getPrijs() {
        return isZwartWit ? 100 : 200;
    }
}

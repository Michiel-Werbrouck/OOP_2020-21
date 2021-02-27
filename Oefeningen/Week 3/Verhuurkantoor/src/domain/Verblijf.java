package domain;

public class Verblijf {

    private int verdiepingnummer;
    private int verblijfnummer;
    private Euro prijsPerVierkanteMeter;
    private int oppervlakte;
    private boolean verhuurStatus;

    public Verblijf(int verdiepingnummer, int verblijfnummer, Euro prijsPerVierkanteMeter, int oppervlakte) {
        if (verblijfnummer < 1) throw new IllegalArgumentException("Verblijfnummer mag niet kleiner dan 1 zijn.");
        if (oppervlakte < 12) throw new IllegalArgumentException("Oppervlakte moet minimaal 12 vierkante meter zijn.");

        this.verdiepingnummer = verdiepingnummer;
        this.verblijfnummer = verblijfnummer;
        this.setPrijsPerVierkanteMeter(prijsPerVierkanteMeter);
        this.oppervlakte = oppervlakte;
        verhuurStatus = false;
    }

    public void setPrijsPerVierkanteMeter(Euro prijsPerVierkanteMeter) {
        if (prijsPerVierkanteMeter.isNegatief()) throw new IllegalArgumentException("Prijs per vierkante meter mag niet negatief zijn.");

        this.prijsPerVierkanteMeter = prijsPerVierkanteMeter;
    }

    public void setVerhuurStatus(boolean verhuurStatus) {
        this.verhuurStatus = verhuurStatus;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "\n"
                + "Bus " + this.verdiepingnummer + "." + this.verblijfnummer + "\n"
                + "Prijs: " + this.prijsPerVierkanteMeter + " euro" + "\n"
                + "Grootte: " + this.oppervlakte + " m²" + "\n"
                + (this.verhuurStatus ? "verhuurd" : "niet verhuurd");
    }

    public Euro prijs() { return prijsPerVierkanteMeter; }

    public int getVerdiepingnummer() {
        return verdiepingnummer;
    }

    public int getVerblijfnummer() {
        return verblijfnummer;
    }

    public int getOppervlakte() {
        return oppervlakte;
    }

    public boolean getVerhuurStatus() {
        return verhuurStatus;
    }

}



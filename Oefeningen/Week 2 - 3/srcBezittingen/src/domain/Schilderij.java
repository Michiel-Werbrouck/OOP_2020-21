package domain;

public class Schilderij extends Bezitting{
    private String titel, schilder;

    public Schilderij(String titel, String schilder, Euro waarde){
        super(waarde);
        this.titel = titel;
        this.schilder = schilder;
    }

    public String getSchilder() {
        return schilder;
    }
}

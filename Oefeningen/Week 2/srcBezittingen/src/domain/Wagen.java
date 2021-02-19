package domain;

public class Wagen extends Bezitting{
    private String eigenaar;
    private int cylinderinhoud;

    public Wagen(String eigenaar, int cylinderinhoud, Euro waarde){
        super(waarde);
        this.eigenaar = eigenaar;
        this.cylinderinhoud = cylinderinhoud;
    }

    public int getCylinderinhoud() {
        return cylinderinhoud;
    }
}

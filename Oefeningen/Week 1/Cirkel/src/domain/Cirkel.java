package domain;

import java.awt.geom.Point2D;

public class Cirkel {
    private Point2D.Double middelpunt;
    private double straal;


    public Cirkel(Point2D.Double middelpunt, double straal){
        if(middelpunt == null){
            throw new IllegalArgumentException();
        }
        this.middelpunt = middelpunt;

        if(straal < 0 || straal > middelpunt.getX() || straal > middelpunt.getY()){
            throw new IllegalArgumentException();
        }
        this.straal = straal;
    }

    public Point2D.Double getMiddelpunt() {

        return middelpunt;
    }

    public double getStraal() {

        return straal;
    }

    public double getOppervlakte(){
        return (2*Math.PI*this.straal);
    }

    public boolean ligtPuntInCirkel(Point2D.Double punt) {
        return (punt.getX() <= this.straal && punt.getY() <= this.straal);
    }

    public Cirkel vergrootStraal(int factor){
        if(this.straal*factor < 0 || this.straal*factor > this.middelpunt.getX() || this.straal*factor > this.middelpunt.getY()){
            throw new IllegalArgumentException();
        }
        return new Cirkel(this.middelpunt, this.straal*factor);
    }

}
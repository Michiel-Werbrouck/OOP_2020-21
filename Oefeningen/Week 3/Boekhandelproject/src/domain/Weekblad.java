package domain;

public class Weekblad extends Artikel{
    private int weekUitgifte;

    public Weekblad(String titel, Euro prijs, int aantal, int weekUitgifte) {
        super(titel, prijs, aantal);
        if (weekUitgifte <= 0) throw new IllegalArgumentException();
        this.weekUitgifte = weekUitgifte;
    }

    public Weekblad(String titel, Euro prijs, int weekUitgifte) {
        super(titel, prijs);
        if (weekUitgifte <= 0) throw new IllegalArgumentException();
        this.weekUitgifte = weekUitgifte;
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o) &&
                ((Weekblad)o).weekUitgifte == this.weekUitgifte;
    }

    @Override
    public String toString(){
        return super.toString() + "Week van uitgifte: " + this.weekUitgifte + "\n";
    }
}

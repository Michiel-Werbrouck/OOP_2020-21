package domain;

import java.util.Objects;

public class Boek extends Artikel{
    private int editie;

    public Boek(String titel, Euro prijs, int aantal, int editie) {
        super(titel, prijs, aantal);
        if (editie <= 0) throw new IllegalArgumentException();
        this.editie = editie;
    }

    public Boek(String titel, Euro prijs, int editie) {
        this(titel,prijs,1,editie);
    }

    @Override
    public boolean equals(Object o){
        return super.equals(o) &&
                ((Boek)o).editie == this.editie;
    }

    @Override
    public String toString(){
        return super.toString() + "Editie: " + this.editie +"\n";
    }
}

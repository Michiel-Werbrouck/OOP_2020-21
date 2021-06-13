package domain;

import java.util.Objects;

public abstract class Kunstwerk {
    private final String titel;
    private final String uitvoerder;
    protected boolean isVerkocht;

    public Kunstwerk(String titel, String uitvoerder) throws DomainException {
        if (titel == null || uitvoerder == null || titel.isBlank())
            throw new DomainException("");

        this.isVerkocht = false;
        this.titel = titel;
        this.uitvoerder = uitvoerder;
    }

    public boolean isVerkocht() {
        return isVerkocht;
    }

    public abstract boolean isUitleenbaar();

    public String getTitel() {
        return titel;
    }

    public String getUitvoerder() {
        return uitvoerder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kunstwerk kunstwerk = (Kunstwerk) o;
        return Objects.equals(titel, kunstwerk.titel) && Objects.equals(uitvoerder, kunstwerk.uitvoerder);
    }
}

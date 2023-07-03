package org.example.domain;

import java.util.Objects;

public class Flugzeug {
    private final int sitzplaetze;
    private final double gewicht;
    private final String modell;

    public Flugzeug(int sitzplaetze,double gewicht, String modell){
        this.sitzplaetze = sitzplaetze;
        this.gewicht = gewicht;
        this.modell = modell;
    }

    @SuppressWarnings("unused")
    public int getSitzplaetze(){
        return sitzplaetze;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flugzeug flugzeug = (Flugzeug) o;
        return sitzplaetze == flugzeug.sitzplaetze && Double.compare(flugzeug.gewicht, gewicht) == 0 && Objects.equals(modell, flugzeug.modell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sitzplaetze, gewicht, modell);
    }

    @SuppressWarnings("unused")
    public double getGewicht() {
        return gewicht;
    }

    public String getModell() {
        return modell;
    }
}

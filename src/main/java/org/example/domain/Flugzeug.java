package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;

import java.util.Objects;

@Aggregate
public class Flugzeug {
    private final int sitzplaetze;
    private final double gewicht;
    private final String modell;

    private final String seriennummer;

    public Flugzeug(int sitzplaetze,double gewicht, String modell, String seriennummer){
        this.sitzplaetze = sitzplaetze;
        this.gewicht = gewicht;
        this.modell = modell;
        this.seriennummer = seriennummer;
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
        return sitzplaetze == flugzeug.sitzplaetze && Double.compare(flugzeug.gewicht, gewicht) == 0 && Objects.equals(modell, flugzeug.modell) && Objects.equals(seriennummer, flugzeug.seriennummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sitzplaetze, gewicht, modell, seriennummer);
    }

    @SuppressWarnings("unused")
    public double getGewicht() {
        return gewicht;
    }

    @SuppressWarnings("unused")
    public String getModell() {
        return modell;
    }

    @SuppressWarnings("unused")
    public String getSeriennummer(){return seriennummer;}
}

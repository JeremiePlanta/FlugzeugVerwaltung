package org.example;

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

    @SuppressWarnings("unused")
    public double getGewicht() {
        return gewicht;
    }

    public String getModell() {
        return modell;
    }
}

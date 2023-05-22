package org.example;

public class Flugzeug {
    private int sitzplätze;
    private double gewicht;
    private String modell;

    public Flugzeug(int sitzplätze,double gewicht, String modell){
        this.sitzplätze = sitzplätze;
        this.gewicht = gewicht;
        this.modell = modell;
    }

    public int getSitzplätze(){
        return sitzplätze;
    }

    public double getGewicht() {
        return gewicht;
    }

    public String getModell() {
        return modell;
    }
}

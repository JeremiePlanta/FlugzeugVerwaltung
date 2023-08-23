package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Flugzeug {
    private final FlugzeugDaten flugzeugDaten;
    private final Seriennummer seriennummer;

    public Flugzeug(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten){
        this.flugzeugDaten = flugzeugDaten;
        this.seriennummer = seriennummer;
    }

    @SuppressWarnings("unused")
    public int getSitzplaetze(){
        return flugzeugDaten.sitzplaetze();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flugzeug flugzeug = (Flugzeug) o;
        return Objects.equals(seriennummer, flugzeug.seriennummer);
    }

    @SuppressWarnings("unused")
    public double getGewicht() {
        return flugzeugDaten.gewicht();
    }

    @SuppressWarnings("unused")
    public String getModell() {
        return flugzeugDaten.modell();
    }

    @SuppressWarnings("unused")
    @AggregateID
    public Seriennummer getSeriennummer(){return seriennummer;}
}

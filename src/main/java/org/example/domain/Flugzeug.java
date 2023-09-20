package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Flugzeug {

    private final Seriennummer seriennummer;
    private final FlugzeugDaten flugzeugDaten;
    private final KontaktDaten kontaktDaten;


    public Flugzeug(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten, KontaktDaten kontaktDaten){
        this.flugzeugDaten = flugzeugDaten;
        this.seriennummer = seriennummer;
        this.kontaktDaten = kontaktDaten;
    }

    public FlugzeugDaten getFlugzeugDaten() {
        return flugzeugDaten;
    }

    public KontaktDaten getKontaktDaten() {
        return kontaktDaten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flugzeug flugzeug = (Flugzeug) o;
        return Objects.equals(seriennummer, flugzeug.seriennummer);
    }


    @SuppressWarnings("unused")
    @AggregateID
    public Seriennummer getSeriennummer(){return seriennummer;}
}

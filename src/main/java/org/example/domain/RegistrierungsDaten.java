package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;

@Aggregate
public class RegistrierungsDaten {
    private final Seriennummer seriennummer;

    private final FlugzeugDaten flugzeugDaten;

    private final KontaktDaten kontaktDaten;

    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten, KontaktDaten kontaktDaten) {
        this.seriennummer = seriennummer;
        this.flugzeugDaten = flugzeugDaten;
        this.kontaktDaten = kontaktDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
        sendVerifizierungsCode();
    }

    public void verifiziere(VerifizierungsCode verifizierungsCode) throws VerifizierungsCodeUngueltig {
        if(this.verifizierungsCode != verifizierungsCode){
            throw new VerifizierungsCodeUngueltig();
        }
    }

    public void sendVerifizierungsCode(){
        publish(new VerifizierungsCodeVerschickt(kontaktDaten.emailAdresse(), verifizierungsCode));
    }
    @AggregateID
    public Seriennummer getSeriennummer() {
        return seriennummer;
    }

    public FlugzeugDaten getFlugzeugDaten() {
        return flugzeugDaten;
    }

    public KontaktDaten getKontaktDaten() {
        return kontaktDaten;
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }
}

package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {

    @Test
    void testeErstelleVerifizierungsCode(){

        //Arrange
        var seriennummer = new Seriennummer("938563857385");
        var flugzeugDaten = new FlugzeugDaten(200, 10000, "Boeing737");
        var kontaktDaten = new KontaktDaten(new EmailAdresse("Fliegeding@domain.air"), "Oberst", "Oben");
        var objectUnderTest = new RegistrierungsDaten(seriennummer, flugzeugDaten, kontaktDaten);
        var empfangeneDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();
        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, empfangeneDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierungsCode();

        //Assert
        assertEquals(1, empfangeneDomainEvents.size());
        assertEquals(36, empfangeneDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }

}
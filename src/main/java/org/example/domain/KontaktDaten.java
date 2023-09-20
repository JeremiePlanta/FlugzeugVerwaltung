package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record KontaktDaten(EmailAdresse emailAdresse, String vorname, String nachname) {
}

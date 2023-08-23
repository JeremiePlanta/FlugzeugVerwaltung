package org.example.domain;

import io.jexxa.addend.applicationcore.ValueObject;

@ValueObject
public record FlugzeugDaten(int sitzplaetze, double gewicht, String modell) {
}

# Motivation
Dieses Projekt ist dazu da die Grundlagen der Software entwicklung zu trainieren.

Es sollen folgende Features implementiert werden:
- Hinzufügen eines Flugzeugs in die FlugzeugVerwaltung
- Löschen eines Flugzeugs aus der FlugzeugVerwaltung
- Anzeigen aller Flugzeuge aus der Flugzeugverwaltung

[User-Story Flugzeug Registrierung]Als FlugzeugManager möchte ich, dass ein Kunde sein Flugzeug Registrieren muss, damit ich die möglichkeit habe die RegistrierungsDaten automatisch zu verifizieren.
- Bei der Registrierung müssen gültige KontaktDaten und FlugzeugDaten angegeben werden.
- Es wird ein 6-stelliger Zahlencode an die angegebene E-Mail-Adresse verschickt
- VerifizierungsCode muss zusammen mit der Seriennummer übergeben werden, damit das Flugzeug in die FlugzeugVerwaltung hinzugefügt wird
- Der Zahlencode verliert nach 24 Stunden seine Gültigkeit

Abbildung auf DDD Mustersprache und Klassen:
ApplicationService: FlugzeugVerwaltung
Neue Methoden: registriere und verifiziere
ValueObjects: E-Mail-Adresse, KontaktDaten, VerifizierungsCode
Aggregate: RegistrierungsDaten, Flugzeug
Repository: RegistrierungsDatenRepository
DomaintEvent: VerifizierungsCodeVerschickt
package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class FlugzeugVerwaltung {

    private final FlugzeugRepository flugzeugRepository;

    private final RegistrierungsDatenRepository registrierungsDatenRepository;

    public FlugzeugVerwaltung(FlugzeugRepository flugzeugRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.flugzeugRepository = flugzeugRepository;
        this.registrierungsDatenRepository = registrierungsDatenRepository;
    }
    public void add(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten, KontaktDaten kontaktDaten){
        flugzeugRepository.add(new Flugzeug(seriennummer, flugzeugDaten, kontaktDaten));
    }
    public void delete(Seriennummer seriennummer){
        flugzeugRepository.remove(seriennummer);
    }
    public List<Seriennummer> get() {
        return flugzeugRepository.getAll().stream().map(Flugzeug::getSeriennummer).toList();
    }

    public void registriere(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten, KontaktDaten kontaktDaten){
        registrierungsDatenRepository.add(new RegistrierungsDaten(seriennummer,flugzeugDaten,kontaktDaten));
    }

    public void verifiziere(Seriennummer seriennummer, VerifizierungsCode verifizierungsCode) throws VerifizierungsCodeUngueltig {
        RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(seriennummer).orElseThrow();
        registrierungsDaten.verifiziere(verifizierungsCode);

        add(seriennummer, registrierungsDaten.getFlugzeugDaten(), registrierungsDaten.getKontaktDaten());
        registrierungsDatenRepository.remove(seriennummer);

    }
}

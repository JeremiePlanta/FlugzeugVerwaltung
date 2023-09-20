package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;

import java.util.List;

@ApplicationService
public class FlugzeugVerwaltung {

    private final FlugzeugRepository flugzeugRepository;

    public FlugzeugVerwaltung(FlugzeugRepository flugzeugRepository){
        this.flugzeugRepository = flugzeugRepository;
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

    }

    public void verifiziere(Seriennummer seriennummer, VerifizierungsCode VerifizierungsCode){

    }
}

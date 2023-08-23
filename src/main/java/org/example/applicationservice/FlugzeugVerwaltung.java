package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugDaten;
import org.example.domain.FlugzeugRepository;
import org.example.domain.Seriennummer;

import java.util.List;

@ApplicationService
public class FlugzeugVerwaltung {

    private final FlugzeugRepository flugzeugRepository;

    public FlugzeugVerwaltung(FlugzeugRepository flugzeugRepository){
        this.flugzeugRepository = flugzeugRepository;
    }
    public void add(Seriennummer seriennummer, FlugzeugDaten flugzeugDaten){
        flugzeugRepository.add(new Flugzeug(seriennummer, flugzeugDaten));
    }
    public void delete(Seriennummer seriennummer){
        flugzeugRepository.remove(seriennummer);
    }
    public List<Seriennummer> get() {
        return flugzeugRepository.getAll().stream().map(Flugzeug::getSeriennummer).toList();
    }
}

package org.example.applicationservice;

import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugRepository;

import java.util.List;

public class FlugzeugVerwaltung {

    private final FlugzeugRepository flugzeugRepository;

    public FlugzeugVerwaltung(FlugzeugRepository flugzeugRepository){
        this.flugzeugRepository = flugzeugRepository;
    }
    public void add(Flugzeug flugzeug){
        flugzeugRepository.add(flugzeug);
    }
    public void delete(Flugzeug flugzeug){
        flugzeugRepository.remove(flugzeug);
    }
    public List<Flugzeug> get() {
        return flugzeugRepository.getAll();
    }
}

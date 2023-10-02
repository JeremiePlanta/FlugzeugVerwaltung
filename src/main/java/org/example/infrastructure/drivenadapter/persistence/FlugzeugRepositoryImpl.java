package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugRepository;
import org.example.domain.Seriennummer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
@DrivenAdapter
public class FlugzeugRepositoryImpl implements FlugzeugRepository {

    private final IRepository<Flugzeug, Seriennummer> flugzeugRepository;

    public FlugzeugRepositoryImpl(Properties properties) {
        this.flugzeugRepository = RepositoryManager.getRepository(Flugzeug.class, Flugzeug::getSeriennummer,properties);
    }

    @Override
    public List<Flugzeug> getAll() {
        return this.flugzeugRepository.get();
    }

    @Override
    public void remove(Seriennummer seriennummer) {
        flugzeugRepository.remove(seriennummer);
    }

    @Override
    public void add(Flugzeug flugzeug) {
        flugzeugRepository.add(flugzeug);
    }

    public void update(Flugzeug flugzeug){
        flugzeugRepository.update(flugzeug);
    }

    public Optional<Flugzeug> get(Seriennummer seriennummer){
        return flugzeugRepository.get(seriennummer);
    }
}

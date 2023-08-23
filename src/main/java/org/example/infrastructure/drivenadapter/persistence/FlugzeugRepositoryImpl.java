package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@DrivenAdapter
public class FlugzeugRepositoryImpl implements FlugzeugRepository {

    private final IRepository<Flugzeug, String> flugzeugRepository;

    public FlugzeugRepositoryImpl(Properties properties) {
        this.flugzeugRepository = RepositoryManager.getRepository(Flugzeug.class, Flugzeug::getSeriennummer,properties);
    }

    @Override
    public List<Flugzeug> getAll() {
        return this.flugzeugRepository.get();
    }

    @Override
    public void remove(Flugzeug flugzeug) {
        flugzeugRepository.remove(flugzeug.getSeriennummer());
    }

    @Override
    public void add(Flugzeug flugzeug) {
        flugzeugRepository.add(flugzeug);
    }
}

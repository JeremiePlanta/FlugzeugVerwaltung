package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugRepository;

import java.util.ArrayList;
import java.util.List;

public class FlugzeugRepositoryImpl implements FlugzeugRepository {

    private final List<Flugzeug> flugzeugList = new ArrayList<>();
    @Override
    public List<Flugzeug> getAll() {
        return this.flugzeugList;
    }

    @Override
    public void remove(Flugzeug flugzeug) {
        flugzeugList.remove(flugzeug);
    }

    @Override
    public void add(Flugzeug flugzeug) {
        flugzeugList.add(flugzeug);
    }
}

package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlugzeugRepository {
     List<Flugzeug> getAll();

     void remove(Seriennummer Seriennummer);

     void add(Flugzeug flugzeug);

     void update(Flugzeug flugzeug);

     Optional<Flugzeug> get(Seriennummer seriennummer);




}

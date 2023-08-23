package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
@Repository
public interface FlugzeugRepository {
     List<Flugzeug> getAll();

     void remove(Flugzeug flugzeug);

     void add(Flugzeug flugzeug);
}

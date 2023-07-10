package org.example.domain;

import java.util.List;

public interface FlugzeugRepository {
     List<Flugzeug> getAll();

     void remove(Flugzeug flugzeug);

     void add(Flugzeug flugzeug);
}

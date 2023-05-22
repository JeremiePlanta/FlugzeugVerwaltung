package org.example;

import java.util.ArrayList;
import java.util.List;

public class FlugzeugVerwaltung {
    private final List<Flugzeug> flugzeugList  = new ArrayList<>();

    public void add(Flugzeug flugzeug){
        flugzeugList.add(flugzeug);
    }
    public void delete(Flugzeug flugzeug){
        flugzeugList.remove(flugzeug);
    }
    public List<Flugzeug> get() {
        return flugzeugList;
    }
}

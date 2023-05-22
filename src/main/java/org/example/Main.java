package org.example;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        FlugzeugVerwaltung flugzeugVerwaltung = new FlugzeugVerwaltung();
        Flugzeug flugzeug747 =new Flugzeug(4,200,"Boeing 747");
        Flugzeug flugzeug737 =new Flugzeug(120,2000,"Boeing 737");
        flugzeugVerwaltung.add(flugzeug737);
        flugzeugVerwaltung.add(flugzeug747);
        List<Flugzeug> alleFlugzeuge = flugzeugVerwaltung.get();
        alleFlugzeuge.forEach(flugzeug -> System.out.println(flugzeug.getModell()));
        flugzeugVerwaltung.delete(flugzeug747);
        alleFlugzeuge = flugzeugVerwaltung.get();
        alleFlugzeuge.forEach(flugzeug -> System.out.println(flugzeug.getModell()));

    }
}
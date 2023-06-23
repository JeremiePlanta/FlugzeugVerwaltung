package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;

import java.util.List;

public class Main {
    @SuppressWarnings({"java:S3400", "unused"})
    // Our business logic ;-)
    public String greetings()
    {
        return "FlugzeugVerwaltung";
    }

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
        var jexxaMain = new JexxaMain(Main.class);


        jexxaMain

                .bind(RESTfulRPCAdapter.class).to(FlugzeugVerwaltung.class)
                .bind(RESTfulRPCAdapter.class).to(Main.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();

    }
}
package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.applicationservice.FlugzeugVerwaltung;
import org.example.domain.FlugzeugRepository;
import org.example.domainservice.StammdatenService;
import org.example.infrastructure.drivenadapter.persistence.FlugzeugRepositoryImpl;

public class Main {
    @SuppressWarnings({"java:S3400", "unused"})
    // Our business logic ;-)
    public String greetings()
    {
        return "FlugzeugVerwaltung";
    }

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        FlugzeugRepository flugzeugRepository = new FlugzeugRepositoryImpl();
        FlugzeugVerwaltung flugzeugVerwaltung = new FlugzeugVerwaltung(flugzeugRepository);
        StammdatenService stammdatenService = new StammdatenService(flugzeugRepository);
        stammdatenService.initStammdaten();

        var jexxaMain = new JexxaMain(Main.class);


        jexxaMain

                .bind(RESTfulRPCAdapter.class).to(flugzeugVerwaltung)
                .bind(RESTfulRPCAdapter.class).to(Main.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();

    }
}
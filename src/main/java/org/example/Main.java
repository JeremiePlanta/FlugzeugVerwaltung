package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.applicationservice.FlugzeugVerwaltung;

import org.example.domain.VerifizierungsCodeVerschickt;
import org.example.domainservice.StammdatenService;
import org.example.domainservice.VerifizierungsCodeSender;
import org.example.infrastructure.drivenadapter.messaging.VerifizierungsCodeSenderImpl;

import static org.example.domain.DomainEventPublisher.subscribe;


public class Main {
    @SuppressWarnings({"java:S3400", "unused"})
    // Our business logic ;-)
    public String greetings()
    {
        return "FlugzeugVerwaltung";
    }

    @SuppressWarnings("java:S106")
    public static void main(String[] args) {

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                .bootstrap(StammdatenService.class).with(StammdatenService::initStammdaten)
                .bootstrap(VerifizierungsCodeSender.class).with(sender -> subscribe(VerifizierungsCodeVerschickt.class, sender::send))

                .bind(RESTfulRPCAdapter.class).to(FlugzeugVerwaltung.class)
                .bind(RESTfulRPCAdapter.class).to(Main.class)
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())
                .run();

    }
}
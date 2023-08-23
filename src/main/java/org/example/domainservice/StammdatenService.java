package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugDaten;
import org.example.domain.FlugzeugRepository;
import org.example.domain.Seriennummer;

import java.util.List;
@DomainService
public class StammdatenService {

    private final FlugzeugRepository flugzeugRepository;

    public StammdatenService(FlugzeugRepository flugzeugRepository) {
        this.flugzeugRepository = flugzeugRepository;
    }
    public void initStammdaten(){

        Flugzeug boeing747 =new Flugzeug(new Seriennummer("232235436"), new FlugzeugDaten(4,200,"Boeing 747"));
        Flugzeug boeing737 =new Flugzeug(new Seriennummer("22323543"), new FlugzeugDaten(120,2000,"Boeing 737"));

        List<Flugzeug> alleFlugzeuge = flugzeugRepository.getAll();
        if(!alleFlugzeuge.contains(boeing747)){
            flugzeugRepository.add(boeing747);
        }
        if(!alleFlugzeuge.contains(boeing737)){
            flugzeugRepository.add(boeing737);
        }
        flugzeugRepository
                .getAll()
                .forEach( element -> System.out.println(element.getSeriennummer()));
    }
}

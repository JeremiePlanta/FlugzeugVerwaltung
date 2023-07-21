package org.example.domainservice;

import org.example.domain.Flugzeug;
import org.example.domain.FlugzeugRepository;

import java.util.List;

public class StammdatenService {

    private static final Flugzeug boeing747 =new Flugzeug(4,200,"Boeing 747", "232235436");
    private static final Flugzeug boeing737 =new Flugzeug(120,2000,"Boeing 737", "22323543");

    private final FlugzeugRepository flugzeugRepository;

    public StammdatenService(FlugzeugRepository flugzeugRepository) {
        this.flugzeugRepository = flugzeugRepository;
    }
    public void initStammdaten(){

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

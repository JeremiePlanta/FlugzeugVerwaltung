package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface RegistrierungsDatenRepository {

    void add(RegistrierungsDaten registrierungsDaten);

    void remove(Seriennummer seriennummer);

    List<RegistrierungsDaten> getAll();

    RegistrierungsDaten get(Seriennummer seriennummer);
}

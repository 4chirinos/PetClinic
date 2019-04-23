package guru.springframework.petclinic.services;

import guru.springframework.petclinic.models.Vet;

import java.util.Set;

public interface VetService {
    Vet findBylastName(String lastName);
    Vet save(Vet owner);
    Set<Vet> findAll();
}

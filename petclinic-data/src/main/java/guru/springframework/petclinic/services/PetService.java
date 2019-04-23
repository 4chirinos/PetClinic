package guru.springframework.petclinic.services;

import guru.springframework.petclinic.models.Pet;

import java.util.Set;

public interface PetService {
    Pet findBylastName(String lastName);
    Pet save(Pet owner);
    Set<Pet> findAll();
}

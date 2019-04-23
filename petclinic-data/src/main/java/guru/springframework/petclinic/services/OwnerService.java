package guru.springframework.petclinic.services;

import guru.springframework.petclinic.models.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);
    Owner findBylastName(String lastName);
    Owner save(Owner owner);
    Set<Owner> findAll();
}

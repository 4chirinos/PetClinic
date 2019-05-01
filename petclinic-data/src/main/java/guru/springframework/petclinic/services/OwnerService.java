package guru.springframework.petclinic.services;

import guru.springframework.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}

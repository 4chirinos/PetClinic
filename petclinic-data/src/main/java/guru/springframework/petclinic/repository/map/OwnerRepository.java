package guru.springframework.petclinic.repository.map;

import guru.springframework.petclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}

package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

}

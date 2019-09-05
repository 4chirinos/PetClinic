package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}

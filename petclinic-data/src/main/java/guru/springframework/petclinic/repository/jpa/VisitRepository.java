package guru.springframework.petclinic.repository.jpa;

import guru.springframework.petclinic.models.Visit;
import guru.springframework.petclinic.repository.map.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

}

package guru.springframework.petclinic.repositories;

import guru.springframework.petclinic.models.Visit;
import guru.springframework.petclinic.services.CrudService;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudService<Visit, Long> {

}

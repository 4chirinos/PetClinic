package guru.springframework.petclinic.services;

import guru.springframework.petclinic.models.Visit;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitService extends CrudService<Visit, Long> {
}

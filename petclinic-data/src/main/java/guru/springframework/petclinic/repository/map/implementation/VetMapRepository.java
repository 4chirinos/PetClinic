package guru.springframework.petclinic.repository.map.implementation;

import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.repository.map.SpecialityRepository;
import guru.springframework.petclinic.repository.map.VetRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapRepository extends AbstractMapRepository<Vet, Long> implements VetRepository {

    private final SpecialityRepository specialityService;

    public VetMapRepository(SpecialityRepository specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            syncBeforeSave(vet);
            return super.save(vet);
        }
        return null;
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    private void syncBeforeSave(Vet vet) {
        Set<Speciality> specialities = vet.getSpecialities();
        CollectionUtils.emptyIfNull(specialities).forEach(speciality -> {
            if (speciality.getId() == null) {
                Speciality savedSpeciality = specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
            }
        });
    }
}

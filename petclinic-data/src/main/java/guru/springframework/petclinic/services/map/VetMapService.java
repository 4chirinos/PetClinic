package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.services.SpecialityService;
import guru.springframework.petclinic.services.VetService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
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

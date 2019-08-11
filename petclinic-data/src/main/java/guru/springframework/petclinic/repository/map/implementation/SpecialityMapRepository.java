package guru.springframework.petclinic.repository.map.implementation;

import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.repository.map.SpecialityRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapRepository extends AbstractMapRepository<Speciality, Long> implements SpecialityRepository {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

package guru.springframework.petclinic.repository.map.implementation;

import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.repository.map.PetTypeRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapRepository extends AbstractMapRepository<PetType, Long> implements PetTypeRepository {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    public PetType save(PetType petType) {
        return super.save(petType);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

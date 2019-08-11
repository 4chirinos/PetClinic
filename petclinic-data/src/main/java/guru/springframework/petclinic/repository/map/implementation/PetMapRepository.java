package guru.springframework.petclinic.repository.map.implementation;

import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.repository.map.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapRepository extends AbstractMapRepository<Pet, Long> implements PetRepository {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}

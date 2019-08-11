package guru.springframework.petclinic.repository.map.implementation;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.repository.map.OwnerRepository;
import guru.springframework.petclinic.repository.map.PetRepository;
import guru.springframework.petclinic.repository.map.PetTypeRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class OwnerMapRepository extends AbstractMapRepository<Owner, Long> implements OwnerRepository {

    private final PetTypeRepository petTypeService;
    private final PetRepository petService;

    public OwnerMapRepository(PetTypeRepository petTypeService, PetRepository petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            syncBeforeSave(owner);
            return super.save(owner);
        }
        return null;
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        List<Owner> owners = new LinkedList<>(super.findAll());
        Owner owner = owners.stream().filter(o -> o.getLastName().equals(lastName)).findFirst().orElse(null);
        return owner;
    }

    private void syncBeforeSave(Owner owner) {
        CollectionUtils.emptyIfNull(owner.getPets()).forEach(pet -> {
            PetType petType = pet.getPetType();
            if (petType == null) {
                throw new RuntimeException("Pet Type is required");
            }
            if (petType.getId() == null) {
                pet.setPetType(petTypeService.save(petType));
            }
            if (pet.getPetType() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });
    }
}

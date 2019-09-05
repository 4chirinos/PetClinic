package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetService;
import guru.springframework.petclinic.services.PetTypeService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
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
            if (pet.getId() == null) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });
    }
}

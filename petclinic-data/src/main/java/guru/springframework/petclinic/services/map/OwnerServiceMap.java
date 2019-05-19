package guru.springframework.petclinic.services.map;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        return super.save(owner);
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
}

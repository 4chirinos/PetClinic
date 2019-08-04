package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Johns");

        Vet v1 = new Vet();
        v1.setFirstName("Sam");
        v1.setLastName("Axe");

        Vet v2 = new Vet();
        v2.setFirstName("Marl");
        v2.setLastName("Charles");

        ownerService.save(o1);
        ownerService.save(o2);
        System.out.println("Loaded owners...");
        vetService.save(v1);
        vetService.save(v2);
        System.out.println("Loaded vets");
    }
}

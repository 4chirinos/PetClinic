package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.repository.map.OwnerRepository;
import guru.springframework.petclinic.repository.map.PetTypeRepository;
import guru.springframework.petclinic.repository.map.SpecialityRepository;
import guru.springframework.petclinic.repository.map.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerRepository ownerService;
    private final VetRepository vetService;
    private final PetTypeRepository petTypeService;
    private final SpecialityRepository specialityService;

    public DataLoader(OwnerRepository ownerService, VetRepository vetService, PetTypeRepository petTypeService,
                      SpecialityRepository specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality dentistrySaved = specialityService.save(dentistry);

        Owner o1 = new Owner();
        o1.setFirstName("Michael");
        o1.setLastName("Weston");
        o1.setAddress("123 Brickerel");
        o1.setCity("Miami");
        o1.setTelephone("12341234");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(o1);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosco");
        o1.getPets().add(mikePet);

        Owner o2 = new Owner();
        o2.setFirstName("Fiona");
        o2.setLastName("Johns");
        o1.setAddress("123 Brickerel");
        o1.setCity("Miami");
        o1.setTelephone("12341234");

        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setOwner(o2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("Rosco");
        o2.getPets().add(fionaCat);

        Vet v1 = new Vet();
        v1.setFirstName("Sam");
        v1.setLastName("Axe");
        v1.getSpecialities().add(savedRadiology);

        Vet v2 = new Vet();
        v2.setFirstName("Marl");
        v2.setLastName("Charles");
        v2.getSpecialities().add(savedSurgery);

        ownerService.save(o1);
        ownerService.save(o2);
        log.info("Loaded owners...");
        vetService.save(v1);
        vetService.save(v2);
        log.info("Loaded vets");
    }
}

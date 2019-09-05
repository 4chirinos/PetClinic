package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.models.Owner;
import guru.springframework.petclinic.models.Pet;
import guru.springframework.petclinic.models.PetType;
import guru.springframework.petclinic.models.Speciality;
import guru.springframework.petclinic.models.Vet;
import guru.springframework.petclinic.models.Visit;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.SpecialityService;
import guru.springframework.petclinic.services.VetService;
import guru.springframework.petclinic.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        o2.setAddress("123 Brickerel");
        o2.setCity("Miami");
        o2.setTelephone("12341234");

        Pet fionaCat = new Pet();
        fionaCat.setPetType(savedCatPetType);
        fionaCat.setOwner(o2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setName("Rosco");
        o2.getPets().add(fionaCat);

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy kitty");

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
        visitService.save(catVisit);
        log.info("Loaded visits");
    }
}

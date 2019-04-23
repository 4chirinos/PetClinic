package guru.springframework.petclinic.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetType extends BaseEntity {
    private String name;
}

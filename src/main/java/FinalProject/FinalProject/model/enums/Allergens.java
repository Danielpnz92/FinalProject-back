package FinalProject.FinalProject.model.enums;

import FinalProject.FinalProject.model.Plates;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

public enum Allergens {
    LACTOSE,
    GLUTEN,
    SEAFOOD,
    PEANUTS,
    EGGS;

}

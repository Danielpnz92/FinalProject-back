package FinalProject.FinalProject.model;

import FinalProject.FinalProject.model.enums.Allergens;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class AllergensValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name="allergen", columnDefinition="ENUM('LACTOSE','GLUTEN','SEAFOOD','PEANUTS','EGGS')",nullable = false)
    private Allergens allergen;
    @ManyToMany
    @JoinTable(
            name = "allergens_plates",
            joinColumns = @JoinColumn(name = "allergens_id"),
            inverseJoinColumns = @JoinColumn(name = "plate_id"))
    @JsonIgnore
    private Set<Plates> platesSet;

    public AllergensValues(Allergens allergen) {
        this.allergen = allergen;
    }

    public Integer getId() {
        return id;
    }

    public Allergens getAllergen() {
        return allergen;
    }

    public void setAllergen(Allergens allergen) {
        this.allergen = allergen;
    }

    public Set<Plates> getPlatesSet() {
        return platesSet;
    }

    public void setPlatesSet(Set<Plates> platesSet) {
        this.platesSet = platesSet;
    }
}

package FinalProject.FinalProject.controller.DTO;

import FinalProject.FinalProject.model.OrderQuantity;
import FinalProject.FinalProject.model.Plates;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
public class PlatesDTO {

    private Set<Plates> platesSet;
    private List<OrderQuantity> platesQuantity;

    public PlatesDTO(Set<Plates> platesSet, List<OrderQuantity> platesQuantity) {
        this.platesSet = platesSet;
        this.platesQuantity = platesQuantity;
    }

    public Set<Plates> getPlatesSet() {
        return platesSet;
    }

    public void setPlatesSet(Set<Plates> platesSet) {
        this.platesSet = platesSet;
    }

    public List<OrderQuantity> getPlatesQuantity() {
        return platesQuantity;
    }

    public void setPlatesQuantity(List<OrderQuantity> platesQuantity) {
        this.platesQuantity = platesQuantity;
    }
}

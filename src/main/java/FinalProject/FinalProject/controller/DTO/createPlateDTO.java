package FinalProject.FinalProject.controller.DTO;

import FinalProject.FinalProject.model.AllergensValues;
import FinalProject.FinalProject.model.Restaurant;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

@NoArgsConstructor
@Data
public class createPlateDTO {
    private String plateName;
    private String plateDesc;
    private String imageURL;
    private Double price;
    private Integer restaurant;
    private Set<AllergensValues> allergensValues;


}

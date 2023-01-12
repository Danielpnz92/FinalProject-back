package FinalProject.FinalProject.controller.DTO;

import FinalProject.FinalProject.model.OrderQuantity;
import FinalProject.FinalProject.model.Plates;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Set;

@NoArgsConstructor
public class PlatesDTO {

    private HashMap<Plates, OrderQuantity> orderDetails;

    public PlatesDTO(HashMap<Plates, OrderQuantity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public HashMap<Plates, OrderQuantity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(HashMap<Plates, OrderQuantity> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

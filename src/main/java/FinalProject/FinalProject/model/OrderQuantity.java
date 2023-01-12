package FinalProject.FinalProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderQuantity {
    //Esta es una tabla auxiliar para referenciar cantidades de los items en el pedido
    @Id
    private Integer quantity;
    @ManyToMany(mappedBy = "platesQuantity")
    @JsonIgnore
    private List<DeliveryOrder> deliveryOrder;

    public OrderQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}



package FinalProject.FinalProject.model;

import FinalProject.FinalProject.model.enums.Allergens;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Plates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plateName;
    private String plateDesc;
    private String imageURL;

    @ManyToMany(mappedBy = "platesSet")
    private Set<AllergensValues> allergens;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "order_plates",
            joinColumns = @JoinColumn(name = "plate_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<DeliveryOrder> orderSet;

    public Plates(String plateName, String plateDesc, String imageURL, Double price, Set<AllergensValues> allergens, Restaurant restaurant) {
        setPlateName(plateName);
        setPlateDesc(plateDesc);
        this.imageURL = imageURL;
        this.price = price;
        this.allergens = allergens;
        this.restaurant = restaurant;
    }

    public Plates(String plateName, String plateDesc, String imageURL, Double price, Restaurant restaurant) {
        this.plateName = plateName;
        this.plateDesc = plateDesc;
        this.imageURL = imageURL;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Integer getId() {
        return id;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getPlateDesc() {
        return plateDesc;
    }

    public void setPlateDesc(String plateDesc) {
        this.plateDesc = plateDesc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Set<AllergensValues> getAllergens() {
        return allergens;
    }

    public void setAllergens(Set<AllergensValues> allergens) {
        this.allergens = allergens;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<DeliveryOrder> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<DeliveryOrder> orderSet) {
        this.orderSet = orderSet;
    }
}

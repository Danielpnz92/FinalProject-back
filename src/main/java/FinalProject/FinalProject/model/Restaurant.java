package FinalProject.FinalProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String restName;
    private String restDesc;
    private String zipCode;
    private String foodType;
    private String restImageURL;
    private Double rating;
    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private Set<Plates> platesSet;
    @OneToMany(mappedBy = "restaurant")
    private Set<DeliveryOrder> orderSet;

    public Restaurant(String name, String desc, String zipCode, String foodType, String imageURL, Double rating, Set<Plates> platesSet) {
        this.restName = name;
        this.restDesc = desc;
        this.zipCode = zipCode;
        this.foodType = foodType;
        this.restImageURL = imageURL;
        this.rating = rating;
        this.platesSet = platesSet;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return restName;
    }

    public void setName(String name) {
        this.restName = name;
    }

    public String getDesc() {
        return restDesc;
    }

    public void setDesc(String desc) {
        this.restDesc = desc;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getImageURL() {
        return restImageURL;
    }

    public void setImageURL(String imageURL) {
        this.restImageURL = imageURL;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<Plates> getPlatesSet() {
        return platesSet;
    }

    public void setPlatesSet(Set<Plates> platesSet) {
        this.platesSet = platesSet;
    }
}

package FinalProject.FinalProject.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Cada pedido pertenece a un único restaurante
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    //Los pedidos constarán de una serie de platos no repetidos
    @ManyToMany(mappedBy = "orderSet")
    private Set<Plates> platesSet;

    //pertenecerán a un único usuario
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date creationDate;

    //y además contarán con una lista de cantidades, correspondientes a las de cada plato
    //añadido al pedido
    @ManyToMany
    @JoinTable(
            name = "order_quantities",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "quantity_id"))
    private List<OrderQuantity> platesQuantity;

    public DeliveryOrder(Restaurant restaurant, User user) {
        this.restaurant = restaurant;
        this.user = user;
        this.creationDate = new Date();
    }

    public DeliveryOrder(Restaurant restaurant, Set<Plates> platesSet, User user, List<OrderQuantity> platesQuantity) {
        this.restaurant = restaurant;
        this.platesSet = platesSet;
        this.user = user;
        this.creationDate = new Date();
        this.platesQuantity = platesQuantity;
    }

    public Integer getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Plates> getPlatesSet() {
        return platesSet;
    }

    public void setPlatesSet(Set<Plates> platesSet) {
        this.platesSet = platesSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<OrderQuantity> getPlatesQuantity() {
        return platesQuantity;
    }

    public void setPlatesQuantity(List<OrderQuantity> platesQuantity) {
        this.platesQuantity = platesQuantity;
    }
}

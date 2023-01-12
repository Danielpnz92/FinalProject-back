package FinalProject.FinalProject.model;

import FinalProject.FinalProject.model.enums.PrimeCategories;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Double points;
    @Enumerated(EnumType.STRING)
    @Column(name="primeCategory", columnDefinition="ENUM('NONE','BRONZE','SILVER','GOLD')",nullable = false)
    private PrimeCategories category;
    private Date registrationDate;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<DeliveryOrder> orderSet;

    public User(String name, String password, String email) {
        setName(name);
        setPassword(password);
        setEmail(email);
        this.points = 0.0;
        this.category = PrimeCategories.NONE;
        this.registrationDate = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setCategory(PrimeCategories category) {
        this.category = category;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;

        if (this.points>=5.0 && this.points<10.0) this.category=PrimeCategories.BRONZE;
        else if (this.points>=10.0 && this.points<20.0) this.category=PrimeCategories.SILVER;
        else if (this.points>=20) this.category=PrimeCategories.GOLD;

    }

    public PrimeCategories getCategory() {
        return category;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Set<DeliveryOrder> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<DeliveryOrder> orderSet) {
        this.orderSet = orderSet;
    }
}

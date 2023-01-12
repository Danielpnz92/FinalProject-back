package FinalProject.FinalProject.model.payment;

import FinalProject.FinalProject.model.User;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="pm_id")
public class Paypal extends PaymentMethod {

    private String email;
    private String payPassword;

    public Paypal(User user, String email, String payPassword) {
        super(user);
        this.email = email;
        this.payPassword = payPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}

package FinalProject.FinalProject.model.payment;

import FinalProject.FinalProject.model.User;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="pm_id")
public class CreditCard extends PaymentMethod {

    private String longNumber;
    private String cvv;
    private Date expirationDate;

    public CreditCard(User user, String longNumber, String cvv, Date expirationDate) {
        super(user);
        this.longNumber = longNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}

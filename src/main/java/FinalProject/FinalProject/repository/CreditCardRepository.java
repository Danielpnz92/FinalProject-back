package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.model.payment.CreditCard;
import FinalProject.FinalProject.model.payment.Paypal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    List<CreditCard> findByUserId(Integer id);
    Optional<CreditCard> findByUserAndLongNumber(User user, String longNumber);
}

package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.User;
import FinalProject.FinalProject.model.payment.Paypal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PaypalRepository extends JpaRepository<Paypal,Integer> {
    List<Paypal> findByUserId(Integer id);
    Optional<Paypal> findByUserAndEmail(User user, String email);
}

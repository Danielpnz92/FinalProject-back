package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.OrderQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderQuantityRepository extends JpaRepository<OrderQuantity, Integer> {
}

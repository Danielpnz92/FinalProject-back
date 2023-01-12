package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.DeliveryOrder;
import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {
    List<DeliveryOrder> findByUserId(Integer id);
}

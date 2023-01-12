package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.Plates;
import FinalProject.FinalProject.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlatesRepository extends JpaRepository<Plates, Integer> {
    Optional<Plates> findByPlateNameAndRestaurant(String plateName, Restaurant restaurant);
    List<Plates> findByRestaurantId(Integer id);
}

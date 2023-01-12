package FinalProject.FinalProject.repository;

import FinalProject.FinalProject.model.AllergensValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergensValuesRepository extends JpaRepository<AllergensValues, Integer> {
}

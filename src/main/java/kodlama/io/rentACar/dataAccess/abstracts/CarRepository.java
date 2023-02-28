package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
}

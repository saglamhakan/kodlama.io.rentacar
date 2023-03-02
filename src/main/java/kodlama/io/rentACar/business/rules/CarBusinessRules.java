package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    @Autowired
    private CarRepository carRepository;

    public void existsByPlate(String plate){
        if (this.carRepository.existsByPlate(plate)){
            throw new BusinessException("Car already exists");
        }
    }
}

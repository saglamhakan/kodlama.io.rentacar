package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    @Autowired
    private ModelRepository modelRepository;

    public void existByModelName(String modelName){
        if (this.modelRepository.existsByModelName(modelName)){
            throw new BusinessException("Model name already exists");
        }
    }
    public void sizeModelName(String modelName){
        if (modelName.length()<3){
            throw new BusinessException("Model name cannot be less than two letters");
        }
    }
}

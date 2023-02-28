package kodlama.io.rentACar.business.rules;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    @Autowired
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String brandName) {
        if (this.brandRepository.existsByBrandName(brandName)) {
            throw new BusinessException("Brand name already exists"); //Java exception types
        }

    }
}

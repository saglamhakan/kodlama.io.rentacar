package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.requests.CreateModelRequest;
import kodlama.io.rentACar.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ModelManager implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override

    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);    }

    @Override
    public List<Model> getByBrandName(String brandName) {
        return modelRepository.getByBrand_BrandName(brandName);
    }
}

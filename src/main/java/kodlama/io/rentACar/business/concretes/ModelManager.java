package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.requests.CreateModelRequest;
import kodlama.io.rentACar.requests.UpdateModelRequest;
import kodlama.io.rentACar.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.responses.GetAllModelsResponse;
import kodlama.io.rentACar.responses.GetByNameModelsResponse;
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

    @Autowired
    private ModelBusinessRules modelBusinessRules;

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
        this.modelBusinessRules.existByModelName(createModelRequest.getModelName());
        this.modelBusinessRules.sizeModelName(createModelRequest.getModelName());
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);    }

    @Override
    public List<GetByNameModelsResponse> getByBrandName(String brandName) {
        List<Model> models=modelRepository.findByModelName(brandName);
        List<GetByNameModelsResponse> modelsResponse=models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetByNameModelsResponse.class)).collect(Collectors.toList());
       return modelsResponse;
    }
    @Override
    public void deleteById(int modelId) {
        modelRepository.deleteById(modelId);
    }

    @Override
    public void updateOneModel(int modelId, UpdateModelRequest updateModelRequest) {
        Model model=this.modelMapperService.forRequest().map(updateModelRequest,Model.class);

        modelRepository.save(model);
    }
}

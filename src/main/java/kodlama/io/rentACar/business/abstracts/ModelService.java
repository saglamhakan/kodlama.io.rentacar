package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.requests.CreateModelRequest;
import kodlama.io.rentACar.requests.UpdateModelRequest;
import kodlama.io.rentACar.responses.GetAllModelsResponse;
import kodlama.io.rentACar.responses.GetByNameModelsResponse;

import java.util.List;

public interface ModelService {
   // List<Model> getAll();
    void add(CreateModelRequest createModelRequest);
    List<GetByNameModelsResponse> getByBrandName(String brandName);

    List<GetAllModelsResponse> getAll();

    void deleteById(int modelId);

    void updateOneModel(int modelId, UpdateModelRequest updateModelRequest);

}

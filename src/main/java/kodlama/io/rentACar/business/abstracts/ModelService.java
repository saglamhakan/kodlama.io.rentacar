package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.requests.CreateModelRequest;
import kodlama.io.rentACar.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
   // List<Model> getAll();
    void add(CreateModelRequest createModelRequest);
    List<Model> getByBrandName(String brandName);

    List<GetAllModelsResponse> getAll();

}

package kodlama.io.rentACar.webApi.Controllers;


import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.requests.CreateModelRequest;
import kodlama.io.rentACar.requests.UpdateModelRequest;
import kodlama.io.rentACar.responses.GetAllModelsResponse;
import kodlama.io.rentACar.responses.GetByNameModelsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/getAll")
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        modelService.add(createModelRequest);
    }

    @GetMapping("/getByBrandName")
    public List<GetByNameModelsResponse> getByBrandName(@RequestParam String brandName) {
        return modelService.getByBrandName(brandName);

    }
    @DeleteMapping("modelId")
    public void deleteById(@RequestParam int modelId){
        modelService.deleteById(modelId);
    }

    @PutMapping("modelId")
    public void updateOneModel(@RequestParam int modelId, @RequestBody UpdateModelRequest updateModelRequest){
        modelService.updateOneModel(modelId, updateModelRequest);
    }
}

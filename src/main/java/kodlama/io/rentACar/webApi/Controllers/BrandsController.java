package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.requests.CreateBrandRequest;
import kodlama.io.rentACar.requests.UpdateBrandRequest;
import kodlama.io.rentACar.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {


    private BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return this.brandService.getAll();
    }

    @GetMapping("{brandId}")
    public GetByIdBrandResponse getById(@PathVariable int brandId) {
        return brandService.findById(brandId);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody  @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("{brandId}")
    public void delete(@PathVariable int brandId) {
        this.brandService.deleteById(brandId);
    }


}

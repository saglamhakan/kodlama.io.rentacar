package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")

public class BrandsController {


    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }
   @GetMapping("/getAll")
   public List<Brand> getAll(){
        return this.brandService.getAll();
   }

    @PostMapping("/add")
    public void add(@RequestBody Brand brand){
         this.brandService.add(brand);
    }



}

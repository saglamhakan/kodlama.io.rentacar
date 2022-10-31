package kodlama.io.rentACar.webApi.Controllers;


import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAll")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Car car){
        carService.add(car);
    }

    @GetMapping("/getByBrandName")
    public List<Car> getByBrandName(@RequestParam String brandName){
        return carService.getByBrandName(brandName);
    }
}

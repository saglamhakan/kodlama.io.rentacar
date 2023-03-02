package kodlama.io.rentACar.webApi.Controllers;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.requests.CreateCarRequest;
import kodlama.io.rentACar.requests.UpdateCarRequest;
import kodlama.io.rentACar.responses.GetAllCarResponse;
import kodlama.io.rentACar.responses.GetByIdCarResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/getAll")
    public List<GetAllCarResponse> getAll(){
       return this.carService.getAll();
    }

    @GetMapping("/carId")
    public GetByIdCarResponses getById(@RequestParam int carId){
        return this.carService.findById(carId);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @PutMapping("/carId")
    public void updateOneCar(@RequestParam int carId, @RequestBody UpdateCarRequest updateCarRequest){
        this.carService.updateOneCar(carId, updateCarRequest);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam int carId){
        this.carService.deleteById(carId);
    }


}

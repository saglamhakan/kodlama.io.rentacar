package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.rules.CarBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.requests.CreateCarRequest;
import kodlama.io.rentACar.requests.UpdateCarRequest;
import kodlama.io.rentACar.responses.GetAllCarResponse;
import kodlama.io.rentACar.responses.GetByIdCarResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService {


    private final CarRepository carRepository;
    @Autowired
    private final ModelMapperService modelMapperService;
    @Autowired
    private final CarBusinessRules carBusinessRules;

    @Autowired
    public CarManager(CarRepository carRepository, ModelMapperService modelMapperService, CarBusinessRules carBusinessRules) {
        this.carRepository = carRepository;
        this.modelMapperService = modelMapperService;
        this.carBusinessRules=carBusinessRules;
    }


    @Override
    public List<GetAllCarResponse> getAll() {
        List<Car> cars = carRepository.findAll();
        List<GetAllCarResponse> carResponses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponse.class)).collect(Collectors.toList());

        return carResponses;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        this.carBusinessRules.existsByPlate(createCarRequest.getPlate());
        Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);

        this.carRepository.save(car);

    }

    @Override
    public void updateOneCar(int carId, UpdateCarRequest updateCarRequest) {
        Car car = this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
        this.carRepository.save(car);
    }


    @Override
    public void deleteById(int carId) {
        this.carRepository.deleteById(carId);
    }

    @Override
    public GetByIdCarResponses findById(int carId) {
        Car car = this.carRepository.findById(carId).orElseThrow();
        GetByIdCarResponses carResponses = this.modelMapperService.forResponse().map(car, GetByIdCarResponses.class);
        return carResponses;
    }
}

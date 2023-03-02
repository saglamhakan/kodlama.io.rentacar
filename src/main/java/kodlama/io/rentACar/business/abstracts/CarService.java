package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.Car;
import kodlama.io.rentACar.requests.CreateCarRequest;
import kodlama.io.rentACar.requests.UpdateCarRequest;
import kodlama.io.rentACar.responses.GetAllCarResponse;
import kodlama.io.rentACar.responses.GetByIdCarResponses;

import java.util.List;

public interface CarService {


    List<GetAllCarResponse> getAll();

    void add(CreateCarRequest createCarRequest);

    void updateOneCar(int carId, UpdateCarRequest updateCarRequest);


    void deleteById(int carId);

    GetByIdCarResponses findById(int carId);

}

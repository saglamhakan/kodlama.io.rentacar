package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    void add(Car car);
    List<Car> getByBrandName(String brandName);
}

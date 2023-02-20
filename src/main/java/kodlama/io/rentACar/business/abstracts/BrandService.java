package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import kodlama.io.rentACar.requests.CreateBrandRequest;
import kodlama.io.rentACar.requests.UpdateBrandRequest;
import kodlama.io.rentACar.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.responses.GetByIdBrandResponse;

import java.util.List;


public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse findById(int brandId);
    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void deleteById(int brandId);

}

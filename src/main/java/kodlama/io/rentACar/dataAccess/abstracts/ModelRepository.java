package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Model;
import kodlama.io.rentACar.responses.GetByNameModelsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
 //   List<GetByNameModelsResponse> getByBrand_BrandName(String brandName);

    //List<Model> findByModelName(String brandName);

    List<Model> findByBrand_BrandName(String brandName);//Jpa naming convention

    boolean existsByModelName(String modelName);


}


package kodlama.io.rentACar.requests;

import lombok.Data;

@Data
public class UpdateBrandRequest {

    private int brandId;
    private String brandName;

}

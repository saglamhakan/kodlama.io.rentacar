package kodlama.io.rentACar.responses;

import lombok.Data;

@Data
public class GetByIdBrandResponse {
    private int brandId;

    private String brandName;
}

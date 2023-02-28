package kodlama.io.rentACar.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {

    private int modelId;
    private String modelName;

    private int brandId;



}

package kodlama.io.rentACar.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNameModelsResponse {

    private int modelId;
    private String modelName;
}

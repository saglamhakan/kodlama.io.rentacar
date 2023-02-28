package kodlama.io.rentACar.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllModelsResponse {

    private int modelId;

    private String name;

    private String brandName;

}

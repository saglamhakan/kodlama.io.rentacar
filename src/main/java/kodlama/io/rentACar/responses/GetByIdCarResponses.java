package kodlama.io.rentACar.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponses {


    private String plate;

    private double dailyPrice;

    private int modelYear;

    private int state;

    private String modelName;
}

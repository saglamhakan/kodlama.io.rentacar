package kodlama.io.rentACar;

import kodlama.io.rentACar.core.utilities.mappers.exceptions.BusinessException;
import kodlama.io.rentACar.core.utilities.mappers.exceptions.ProblemDetails;
import kodlama.io.rentACar.core.utilities.mappers.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class  RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}



	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.Exception");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(Exception ex){
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(ex.getMessage());

		return problemDetails;
	}










	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}

package ie.atu.onlineshopp.GlobalExceptionDetails;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling
{
@ExceptionHandler(UnexpectedTypeException.class)
        public String ShowErrorDetails()
{
    return("Please Enter Valid Type");
}
@ExceptionHandler(HttpMessageNotReadableException.class)
        public String ShowErrorDetails(HttpMessageNotReadableException e)
{
    return("Please Enter Valid ID");
}

}

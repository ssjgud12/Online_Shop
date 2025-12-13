package ie.atu.onlineshopp.controller.GlobalExceptionDetails;

import jakarta.validation.UnexpectedTypeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling
{
@ExceptionHandler(UnexpectedTypeException.class)
        public String ShowErrorDetails()
{
    return("UnexpectedTypeException");
}

}

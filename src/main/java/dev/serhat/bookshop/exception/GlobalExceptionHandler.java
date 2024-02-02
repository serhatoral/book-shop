package dev.serhat.bookshop.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> dataNotFoundExectionHandler(DataNotFoundException dataNotFoundException){

        return  new ResponseEntity<>(createCustomErrorResponse(
                dataNotFoundException,HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);

            // return new ResponseEntity<>(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
            // Bu şekilde direkt mesajı verdiğimizde text olarak gidiyor
            // json şeklinde gitmesi için için obje göndermemeiz gerekli
    }

    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<CustomErrorResponse> customerAlreadyExistException(CustomerAlreadyExistException customerAlreadyExistException){


        return  new ResponseEntity<>(createCustomErrorResponse(
                customerAlreadyExistException, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);

    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomErrorResponse> customerAlreadyExistException(){

        BadCredentialsException badCredentialsException = new BadCredentialsException("Şifre Yanlış");
        return   new ResponseEntity<>(createCustomErrorResponse(badCredentialsException,HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
    }


    private CustomErrorResponse createCustomErrorResponse(RuntimeException exception,HttpStatus status){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setError(exception.getMessage());
        customErrorResponse.setStatus(status.value());
        customErrorResponse.setTimestamp(LocalDateTime.now());

        return customErrorResponse;
    }

}

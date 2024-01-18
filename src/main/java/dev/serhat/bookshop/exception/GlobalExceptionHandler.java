package dev.serhat.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {




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


    private CustomErrorResponse createCustomErrorResponse(RuntimeException exception,HttpStatus status){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setError(exception.getMessage());
        customErrorResponse.setStatus(status.value());
        customErrorResponse.setTimestamp(LocalDateTime.now());

        return customErrorResponse;
    }

}

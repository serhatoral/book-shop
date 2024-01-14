package dev.serhat.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> dataNotFoundExectionHandler(DataNotFoundException dataNotFoundException){

        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setError(dataNotFoundException.getMessage());
        customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        customErrorResponse.setTimestamp(LocalDateTime.now());

        return  new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
       // return new ResponseEntity<>(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND); // Bu şekilde direkt mesajı verdiğimizde text olarak gidiyor
                                                                                                    // json şeklinde gitmesi için için obje göndermemeiz gerekli
    }


}

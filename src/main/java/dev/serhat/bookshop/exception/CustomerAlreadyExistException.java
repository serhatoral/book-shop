package dev.serhat.bookshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException{

    public CustomerAlreadyExistException() {
        super("Bu email'e ait müşteri bulunmaktadır.");
    }
}

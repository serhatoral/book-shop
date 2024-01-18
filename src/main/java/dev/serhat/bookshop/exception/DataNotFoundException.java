package dev.serhat.bookshop.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class DataNotFoundException  extends RuntimeException{

    private Object data;

    public DataNotFoundException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public DataNotFoundException(String message) {
        super(message);
    }
}

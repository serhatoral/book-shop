package dev.serhat.bookshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SuccessfulResponse {

    private String message;

    public SuccessfulResponse(String message) {
        this.message = message;
    }
}

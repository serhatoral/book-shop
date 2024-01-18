package dev.serhat.bookshop.dto.customers;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}

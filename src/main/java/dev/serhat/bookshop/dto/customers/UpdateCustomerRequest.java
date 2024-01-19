package dev.serhat.bookshop.dto.customers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerRequest {

    @NotNull
    private int id;

    @NotBlank
    @NotNull
    private String email;

    @Size(min = 3,max = 50)
    private String firstName;

    @Size(min = 3,max = 50)
    private String lastName;

}

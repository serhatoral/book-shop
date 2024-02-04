package dev.serhat.bookshop.dto.customers;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCustomerRequest {

    @Size(min = 3, max = 50)
    private String firstName;

    @Size(min = 3, max = 50)
    private String lastName;

    @NotBlank(message = "Email boş olamaz!")
    @NotNull(message = "Email alanını doldurun!")
    @Email
    private String email;

    @NotBlank(message = "password boş olamaz!")
    @NotNull(message = "password alanını doldurun!")
    private String password;
}

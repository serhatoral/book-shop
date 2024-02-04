package dev.serhat.bookshop.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @Email
    @NotBlank(message = "Email boş olamaz!")
    @NotNull(message = "Email alanını doldurun!")
    private String email;


    @NotBlank(message = "password boş olamaz!")
    @NotNull(message = "password alanını doldurun!")
    private String password;
}

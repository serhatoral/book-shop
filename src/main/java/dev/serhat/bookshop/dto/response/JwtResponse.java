package dev.serhat.bookshop.dto.response;


import dev.serhat.bookshop.dto.customers.CustomerDto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class JwtResponse {

    private LocalDateTime generationTime = LocalDateTime.now();
    private String token;
    private CustomerDto user;

    public JwtResponse(String token,CustomerDto user) {
        this.token = token;
        this.user = user;
    }
}

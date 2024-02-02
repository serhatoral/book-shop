package dev.serhat.bookshop.dto.response;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class JwtResponse {

    private LocalDateTime generationTime = LocalDateTime.now();
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}

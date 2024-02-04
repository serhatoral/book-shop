package dev.serhat.bookshop.controller;


import dev.serhat.bookshop.dto.request.AuthRequest;
import dev.serhat.bookshop.security.JwtGenerator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/auth")
@CrossOrigin(origins = "http://localhost:9090")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@Valid @RequestBody AuthRequest authRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));

        return ResponseEntity.ok(jwtGenerator.getJwtResponse(authRequest.getEmail()));

    }
}

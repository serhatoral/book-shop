package dev.serhat.bookshop.controller;


import dev.serhat.bookshop.dto.request.AuthRequest;
import dev.serhat.bookshop.exception.DataNotFoundException;
import dev.serhat.bookshop.security.JwtGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest){


        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword()));

        if(authentication.isAuthenticated())
            return ResponseEntity.ok(jwtGenerator.generateToken(authRequest.getEmail()));
        else
            return  new ResponseEntity<>(new DataNotFoundException("böyle bir kulanıcı yok"), HttpStatus.NOT_FOUND);
    }
}

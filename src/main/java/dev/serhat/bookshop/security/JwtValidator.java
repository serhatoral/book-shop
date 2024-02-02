package dev.serhat.bookshop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtValidator {


    public Boolean validateToken(String token, UserDetails userDetails){

        String email = extractUser(token);
        Date expirationDate = extractEcpirationDate(token);

         return userDetails.getUsername().equals(email)  && expirationDate.after(new Date());
    }

    public Claims extractClaims(String token){

        return Jwts.parser()
                .verifyWith(JwtGenerator.getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUser(String token){
        Claims claims = extractClaims(token);

        return claims.getSubject();
    }

    public Date extractEcpirationDate(String token){
        Claims claims = extractClaims(token);

        return claims.getExpiration();
    }


}

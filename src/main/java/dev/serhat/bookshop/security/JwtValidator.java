package dev.serhat.bookshop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtValidator {


    public Boolean validateToken(String token, UserDetails userDetails){

        String email = extractUser(token);
        Date expirationDate = extractEcpirationDate(token);

         return userDetails.getUsername().equals(email)  && expirationDate.after(new Date());
    }

    public Boolean isTokenExpired(String token){
            try {
                return extractEcpirationDate(token).before(new Date());
            }catch (ExpiredJwtException expiredJwtException){
                return true;
            }

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

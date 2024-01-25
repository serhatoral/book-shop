package dev.serhat.bookshop.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtGenerator {

    //@Value("${jwt.key}")
    private static final String SECRET_KEY =" MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSGAeWR1NR17e6jGKaXAuN8eaHVE/elhzGWi2XDEcHq3+K0eAE6MQKUZS30HBCkG8WJx9Av0aMzTZlYvxEksE+6kc+YC9iPYZ0sHX+gq0EXyyYzE9AfrAxJ2TRtXEJk9HVihfwr9431gytkbDLltaueT440XZmkZNYqMzmIa73RwIDAQAB";

    public String generateToken(String username){
        Map<String,Object> claims = new HashMap<>();
        claims.put("taner", "güngör");

        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 15))
                .signWith(getSignKey()).compact();
    }

    protected static SecretKey getSignKey(){

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

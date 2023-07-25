package com.tennis.tennis_break_academy.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static com.tennis.tennis_break_academy.security.Constants.EXPIRY_DATE;
import static com.tennis.tennis_break_academy.security.Constants.SECRET_KEY;
@Component
public class JWTGenerator {
    @SuppressWarnings("deprecation")
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        
        // Set expiration date to 1 hour from the current date
        LocalDateTime expirationLocalDateTime = LocalDateTime.now().plusHours(1);
        Date expirationDate = Date.from(expirationLocalDateTime.atZone(ZoneId.systemDefault()).toInstant());

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return token;
    }
    public String getUsernameFromJWT(String token){
        @SuppressWarnings("deprecation")
		Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
    @SuppressWarnings("deprecation")
	public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token);
            return true;
        }catch(Exception ex){
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}

package com.mastersystem.mcmanager.infrastructure.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Log4j2
public class JwtUtil {
    private static final String SECRET_KEY = "c68e47b204651a6a3d958261a327ec047b24f3daeb2e591cc1a99ad395bc5db9";

    public static String generateToken(String username){
        log.info("[class] JwtUtil - generateToken");
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000  * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String getUsernameFromToken(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public boolean validateToken(String token) {
        try{
            Claims claims = extractAllClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());
        } catch (Exception e){
            return false;
        }
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver){
        Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }

    @FunctionalInterface
    private interface ClaimsResolver<T>{
        T resolve(Claims claims);
    }
}

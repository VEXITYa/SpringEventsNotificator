package dev.kuchishkin.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenManager {

    private final SecretKey secretKey;
    private final long lifetime;


    public JwtTokenManager(
        @Value("${jwt.secret-key}") String stringKey,
        @Value("${jwt.lifetime}") long lifetime
    ) {
        this.secretKey = Keys.hmacShaKeyFor(stringKey.getBytes());
        this.lifetime = lifetime;
    }

    public Long getUserIdFromToken(String token) {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .get("user_id", Long.class);
    }

    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
            .verifyWith(secretKey)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}

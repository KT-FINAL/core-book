package com.example.book.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private Key secretKey;

    // @Value 어노테이션을 사용하여 프로퍼티 파일에서 시크릿 키를 읽어옴
    @Value("${jwt.secret.key}")
    public void setSecretKey(String secretKeyString) {
        this.secretKey = Keys.hmacShaKeyFor(secretKeyString.getBytes());
    }

    public TokenInfo extractTokenInfo(String token) {
        // "Bearer " 접두사 제거
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        // JWT 토큰에서 클레임 추출
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();

        // TokenInfo 객체 생성 및 반환
        return new TokenInfo(
            claims.get("userId", Long.class)  // userId
        );
    }

    public String generateToken(String userEmail, Long userId) {
        return Jwts.builder()
                .setSubject(userEmail)
                .claim("userId", userId)
                .signWith(secretKey)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
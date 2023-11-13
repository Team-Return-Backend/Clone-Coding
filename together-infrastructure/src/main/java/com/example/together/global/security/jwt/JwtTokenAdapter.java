package com.example.together.global.security.jwt;

import com.example.domain.auth.dto.TokenResponse;
import com.example.domain.auth.spi.JwtPort;
import com.example.together.domain.auth.RefreshToken;
import com.example.together.domain.auth.RefreshTokenRepository;
import com.example.together.global.exception.ExpiredTokenException;
import com.example.together.global.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenAdapter implements JwtPort {

    private final JwtProperties jwtProperties;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenResponse createToken(String email) {
        return TokenResponse
                .builder()
                .accessToken(createAccessToken(email))
                .refreshToken(createRefreshToken(email))
                .build();
    }

    // JWT 토큰 생성
    public String createAccessToken(String email) {
        Claims claims = Jwts.claims().setSubject(email); // JWT payload 에 저장되는 정보단위, 보통 여기서 user를 식별하는 값을 넣는다.
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) // 정보 저장
                .setIssuedAt(now) // 토큰 발행 시간 정보
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExp() * 1000)) // set Expire Time
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .compact();

    }


    private String createRefreshToken(String email) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .setSubject(email)
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExp() * 1000))//만료시간은
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .email(email)
                        .refreshToken(refreshToken)
                        .expiration(jwtProperties.getRefreshExp())
                        .build());

        return refreshToken;
    }


    public TokenResponse reissue(String refreshToken) {

        if(!isRefreshToken(refreshToken))
            throw InvalidTokenException.EXCEPTION;

        String email = getId(refreshToken);

        return TokenResponse.builder()
                .accessToken(createAccessToken(email))
                .refreshToken(refreshToken)
                .build();
    }

    private boolean isRefreshToken(String token) {
        return getClaims(token).get("type").equals("refresh");

    }

    private String getId(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

}

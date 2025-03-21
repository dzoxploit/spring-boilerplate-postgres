package com.example.spring_boilerplate_stater.security.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.spring_boilerplate_stater.model.User;
import com.example.spring_boilerplate_stater.model.UserRole;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {
    
    private final JwtProperties jwtProperties;

    private DecodedJWT getDecodedJWT(String token){
        final JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes())).build();
        return jwtVerifier.verify(token);
    }

    private Date getExpirationDateFromToken(String token){
        final DecodedJWT decodedJWT = getDecodedJWT(token);
        return decodedJWT.getExpiresAt();
    }

    private boolean isTokenExpired(String token) {
        final Date expirationDateFromToken = getExpirationDateFromToken(token);
        return expirationDateFromToken.before(new Date());
    }

    public String generateTokenAuth(User user){
        final String username = user.getUsername();
        final UserRole userRole = user.getUserRole();

        return JWT.create()
                         .withSubject(username)
                         .withIssuer(jwtProperties.getIssuer())
                         .withClaim("role", userRole.name())
                         .withIssuedAt(new Date())
                         .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpirateMinute() * 60 * 2000))
                         .sign(Algorithm.HMAC256(jwtProperties.getSecretKey().getBytes()));
    }

    public String getUsernameFromToken(String token){
        final DecodedJWT decodedJWT = getDecodedJWT(token);

        return decodedJWT.getSubject();
    }

    
    public boolean validateToken(String token, String authenticatedUsername){
        final String usernameFromToken = getUsernameFromToken(token);

        final boolean equalsUsername = usernameFromToken.equals(authenticatedUsername);

        final boolean tokenExpired = isTokenExpired(token);

        return equalsUsername && !tokenExpired;
    }

}

package com.example.spring_boilerplate_stater.security.jwt;

import org.springframework.stereotype.Component;

import com.example.spring_boilerplate_stater.model.User;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtTokenManager {
    
    private final JwtProperties jwtProperties;

    public String generateTokenAuth(User user){
        return "ok";
    }

}

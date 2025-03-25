package com.example.spring_boilerplate_stater.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boilerplate_stater.security.dto.LoginRequest;
import com.example.spring_boilerplate_stater.security.dto.LoginResponse;
import com.example.spring_boilerplate_stater.security.jwt.JwtTokenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    private final JwtTokenService jwtTokenService;

    @PostMapping
    @Operation(tags = "Login Service", description = "You must login with the correct information to successfully obtain the token information")

    public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest){
        
        final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }
}

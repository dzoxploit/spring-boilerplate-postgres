package com.example.spring_boilerplate_stater.config;

import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    
    private final JwtAuthenticationFilter JwtAuthenticationFilter;

    
    @Bean

}

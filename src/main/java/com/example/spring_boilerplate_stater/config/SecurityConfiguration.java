package com.example.spring_boilerplate_stater.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import com.example.spring_boilerplate_stater.security.jwt.JwtAuthenticationEntryPoint;
import com.example.spring_boilerplate_stater.security.jwt.JwtAuthenticationFilter;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    
    private final JwtAuthenticationEntryPoint unauthorizedHandler;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(CsrfConfigurer::disable)
                .cors(CorsConfigurer::disable)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> request.requestMatchers("/register",
																	      "/login",
																	      "/v3/api-docs/**",
																          "/swagger-ui/**",
																	      "/swagger-ui.html",
																	      "/actuator/**")
													   .permitAll()
													   .anyRequest()
													   .authenticated())
				.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.exceptionHandling(handler -> handler.authenticationEntryPoint(unauthorizedHandler))
				.build();
    }



}

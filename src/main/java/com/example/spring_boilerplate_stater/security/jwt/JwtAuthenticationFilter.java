package com.example.spring_boilerplate_stater.security.jwt;

import java.io.IOException;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.spring_boilerplate_stater.security.service.UserDetailsServiceImpl;
import com.example.spring_boilerplate_stater.security.utils.SecurityConstants;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class JwtAuthenticationFilter  extends OncePerRequestFilter{

    private final JwtTokenManager jwtTokenManager;

    private final UserDetailsServiceImpl userDetailsService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException{
        final String header = request.getHeader(SecurityConstants.HEADER_STRING);

        String username = null;
        String authToken = null;

        if(Objects.nonNull(header) && header.startsWith(SecurityConstants.TOKEN_PREFIX)){
            authToken = header.replace(SecurityConstants.TOKEN_PREFIX, Strings.EMPTY);
            
            try {
                username = jwtTokenManager.ge
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }    
}

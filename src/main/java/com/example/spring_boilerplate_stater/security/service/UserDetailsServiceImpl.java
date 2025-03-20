package com.example.spring_boilerplate_stater.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private static final String USERNAME_OR_PASSWORD_INVALID = "invalid username or password";

    private final UserService userService;
    
}

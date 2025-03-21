package com.example.spring_boilerplate_stater.security.utils;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 24 * 60 * 60 * 2000;

    public static final String SECRET_KEY = "mySecretKey";


    public static final String ISSUER = "www.boilerplate.design";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_STRING = "Authorization";

    public static final String REGISTRATION_REQUEST_URI = "/register";

    private SecurityConstants() {
        throw new UnsupportedOperationException();
    }
    
}

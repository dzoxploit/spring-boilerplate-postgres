package com.example.spring_boilerplate_stater.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {
    private final String errorMessage;
}

package com.example.spring_boilerplate_stater.service;

import org.springframework.stereotype.Service;

import com.example.spring_boilerplate_stater.repository.UserRepository;
import com.example.spring_boilerplate_stater.security.dto.RegistrationRequest;
import com.example.spring_boilerplate_stater.utils.ExceptionMessageAccessor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidationService {
    
    private static final String EMAIL_ALREADY_EXISTS = "email_already_exists";

    private static final String USERNAME_ALREADY_EXISTS = "username_already_exists";

    private final UserRepository userRepository;

    private final ExceptionMessageAccessor exceptionMessageAccessor;

    public void validateUser(RegistrationRequest registrationRequest) {
        
        final String email = registrationRequest.getEmail();

        final String username = registrationRequest.getUsername();

        checkEmail(email);
        checkUsername(username);

    }

    private void checkUsername(String username){
        final boolean existsByUsername = userRepository.existsByUsername(username);

        if(existsByUsername) {
            log.warn("{} is already be used", username);
            throw new RegistrationException(existsByUsername);
        }
    }
}

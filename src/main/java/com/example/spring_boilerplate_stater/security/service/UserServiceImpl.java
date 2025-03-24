package com.example.spring_boilerplate_stater.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_boilerplate_stater.model.User;
import com.example.spring_boilerplate_stater.repository.UserRepository;
import com.example.spring_boilerplate_stater.security.dto.AuthenticatedUserDto;
import com.example.spring_boilerplate_stater.security.dto.RegistrationRequest;
import com.example.spring_boilerplate_stater.security.dto.RegistrationResponse;
import com.example.spring_boilerplate_stater.service.UserValidationService;
import com.example.spring_boilerplate_stater.utils.GeneralMessageAccessor;
import com.example.spring_boilerplate_stater.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {@Override
    
    
    private static final String REGISTRATION_SUCCESSFULL = "registration_successfull";

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserValidationService userValidationService;

    private final GeneralMessageAccessor generalMessageAccessor;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);   
    }

    @Override
    public RegistrationResponse regisgtration(RegistrationRequest registrationRequest) {
        userValidationService.validateUser(registrationRequest);
    }

    @Override
    public AuthenticatedUserDto findAuthenticatedUserByUsername(String Username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAuthenticatedUserByUsername'");
    }
    
}

package com.example.spring_boilerplate_stater.security.service;

import com.example.spring_boilerplate_stater.model.User;
import com.example.spring_boilerplate_stater.security.dto.AuthenticatedUserDto;
import com.example.spring_boilerplate_stater.security.dto.RegistrationRequest;
import com.example.spring_boilerplate_stater.security.dto.RegistrationResponse;

public interface UserService {
    User findByUsername(String username);

    RegistrationResponse regisgtration(RegistrationRequest registrationRequest);

    AuthenticatedUserDto findAuthenticatedUserByUsername(String Username);
}

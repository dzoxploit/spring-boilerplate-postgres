package com.example.spring_boilerplate_stater.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.example.spring_boilerplate_stater.model.User;
import com.example.spring_boilerplate_stater.security.dto.AuthenticatedUserDto;
import com.example.spring_boilerplate_stater.security.dto.LoginRequest;
import com.example.spring_boilerplate_stater.security.dto.LoginResponse;
import com.example.spring_boilerplate_stater.security.mapper.UserMapper;
import com.example.spring_boilerplate_stater.security.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final UserService userService;

    private final JwtTokenManager jwtTokenManager;

    private final AuthenticationManager authenticationManager;

    public LoginResponse getLoginResponse(LoginRequest loginRequest) {
        final String username = loginRequest.getUsername();

        final String password = loginRequest.getPassword();

        final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        final AuthenticatedUserDto authenticatedUserDto = userService.findAuthenticatedUserByUsername(username);

		final User user = UserMapper.INSTANCE.convertToUser(authenticatedUserDto);
		final String token = jwtTokenManager.generateTokenAuth(user);

		log.info("{} has successfully logged in!", user.getUsername());

		return new LoginResponse(token);
    }
    
}

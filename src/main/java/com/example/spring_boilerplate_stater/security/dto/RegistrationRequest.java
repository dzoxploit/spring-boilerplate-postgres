package com.example.spring_boilerplate_stater.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationRequest {
    
    @NotEmpty(message = "{registration_name_not_empty}")
    private String name;

    @NotEmpty(message = "registration_username_not_empty")
    private String username;

    @Email(message = "{registration_email_is_not_valid}")
    @NotEmpty(message = "registration_password_not_empty")
    private String email;

    @NotEmpty(message = "registration_password_not_empty")
    private String password;

}

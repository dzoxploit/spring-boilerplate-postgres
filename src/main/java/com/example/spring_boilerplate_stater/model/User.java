package com.example.spring_boilerplate_stater.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;


@EntityScan
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    
    @Generated
    private Long id;
    
    private String name;

    private String username;
    private String password;
    private String email;
    
    private UserRole userRole;


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public UserRole getUserRole(){
        return userRole;
    }

    public void setUserRole(UserRole userRole){
        this.userRole = userRole;
    }
    
}

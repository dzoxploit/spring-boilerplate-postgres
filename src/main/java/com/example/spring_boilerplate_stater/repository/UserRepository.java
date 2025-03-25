package com.example.spring_boilerplate_stater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_boilerplate_stater.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
    
}

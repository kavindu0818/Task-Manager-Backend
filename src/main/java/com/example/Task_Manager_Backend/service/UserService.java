package com.example.Task_Manager_Backend.service;
import com.example.Task_Manager_Backend.dto.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity saveUser(UserEntity user);

    UserEntity getUser(String id);
}

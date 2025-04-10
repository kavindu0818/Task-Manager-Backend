package com.example.Task_Manager_Backend.service.impl;
import com.example.Task_Manager_Backend.dto.UserEntity;
import com.example.Task_Manager_Backend.dao.UserRepository;
import com.example.Task_Manager_Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity saveUser(UserEntity user) {
        if (userRepository.findByUsername(user.getUsername()) != null) throw new RuntimeException("User already registered");
        user.setPassword("{noop}" + user.getPassword());
        return userRepository.save(user);
    }
    @Override
    public UserEntity getUser(String id) {
        return userRepository.findByUsername(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}

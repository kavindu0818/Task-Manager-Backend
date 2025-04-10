package com.example.Task_Manager_Backend.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Repository;

import java.io.File;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Repository
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;
//    private File image;  // Store image as Base64 string

    public UserEntity() {
    }

    public UserEntity(Long id, String email, String username, String password, String role, File image) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
//        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

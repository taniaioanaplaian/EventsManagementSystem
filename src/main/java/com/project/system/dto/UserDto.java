package com.project.system.dto;

import com.project.system.enumeration.UserRole;

public class UserDto {

    private Long id;
    private String username;
    private UserRole role;
    private String password;

    public UserDto(){

    }

    public UserDto(Long id, String username, UserRole role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

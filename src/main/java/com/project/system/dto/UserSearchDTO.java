package com.project.system.dto;

import com.project.system.enumeration.UserRole;

public class UserSearchDTO {

    private String username;
    private UserRole role;

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
}

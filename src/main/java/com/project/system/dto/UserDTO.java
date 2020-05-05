package com.project.system.dto;
import com.project.system.enumeration.UserRole;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserDTO extends NameIdDTO  {

    @NotBlank
    private String username;
    @Length(min = 6)
    private String password;
    private UserRole role;

    public UserDTO(){

    }
    public UserDTO(@NotBlank String username, @Length(min = 6) String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(Long id, String name, @NotBlank String username, @Length(min = 6) String password, UserRole role) {
        super(id, name);
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public void setName(String name) {
        this.username = name;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

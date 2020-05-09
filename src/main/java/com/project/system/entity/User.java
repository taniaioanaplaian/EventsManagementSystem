 package com.project.system.entity;

import com.project.system.enumeration.UserRole;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

 @Entity(name = "ps_user")
 public class User implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long userId;
     private String username;
     private String password;
     @Enumerated(value = EnumType.STRING)
     private UserRole role;

     public User() {
     }

     public User(Long id, String username, String password, UserRole role){
         this.userId = id;
         this.username = username;
         this.password = password;
         this.role = role;
     }

     public void setUserId(Long id){
         this.userId = id;
     }
     public Long getUserId() {
         return userId;
     }
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         User user = (User) o;
         return Objects.equals(userId, user.userId) &&
                 Objects.equals(username, user.username) &&
                 Objects.equals(password, user.password) &&
                 role == user.role;
     }

     @Override
     public int hashCode() {
         return Objects.hash(userId, username, password, role);
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

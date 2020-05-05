package com.project.system.repository;

import com.project.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(final Long id);
    User findByUsernameIgnoreCase(String username);
    List<User> findAll();

}



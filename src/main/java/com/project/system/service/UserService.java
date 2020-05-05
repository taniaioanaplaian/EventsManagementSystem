package com.project.system.service;

import com.project.system.dto.UserDTO;
import java.util.List;
public interface UserService {
    UserDTO save(UserDTO userDto);
    List<UserDTO> findAll();
    UserDTO findById(Long id);
    void deleteById(Long id);

}

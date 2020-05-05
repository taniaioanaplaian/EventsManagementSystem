package com.project.system.validator;

import com.mysql.cj.util.StringUtils;
import com.project.system.dto.UserDTO;
import com.project.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
public class UserValidator {

    private final UserRepository userRepository;

    @Autowired
    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateUser(UserDTO userDTO, BindingResult result) {

        if(!StringUtils.isNullOrEmpty(userDTO.getUsername()) &&
                userRepository.findByUsernameIgnoreCase(userDTO.getUsername()) != null) {
            result.rejectValue("username", "UsernameDuplicate");
        }

    }
}

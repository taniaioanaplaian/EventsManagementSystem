package com.project.system.service.impl;

import com.project.system.dto.UserDto;
import com.project.system.entity.User;
import com.project.system.mapper.UserMapper;
import com.project.system.repository.UserDAO;
import com.project.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user;
        if(userDto.getId() != null) {
            user = userDAO.findById(userDto.getId()).orElse(null);
        } else {
            user = new User();
        }

        userMapper.toEntityUpdate(user, userDto);
        assert user != null;
        return userMapper.toDTO(userDAO.save(user));
    }
}

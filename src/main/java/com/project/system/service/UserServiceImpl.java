package com.project.system.service;

import com.mysql.cj.util.StringUtils;
import com.project.system.dto.UserDTO;
import com.project.system.dto.UserSearchDTO;
import com.project.system.entity.User;
import com.project.system.mapper.UserMapper;
import com.project.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDto) {
        Optional<User> user;
        if(userDto.getId() != null) {
            user = userRepository.findById(userDto.getId());
        } else {
            user = Optional.of(new User());

        }
        userMapper.toEntityUpdate(user.orElse(null), userDto);
        assert user.orElse(null) != null;
        return userMapper.toDTO(userRepository.save(user.orElse(null)));
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long id) {
        return userMapper.toDTO(userRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
         userRepository.deleteById(id);
    }


}

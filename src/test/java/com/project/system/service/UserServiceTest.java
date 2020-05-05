package com.project.system.service;

import com.project.system.dto.UserDTO;
import com.project.system.entity.User;
import com.project.system.enumeration.UserRole;
import com.project.system.mapper.UserMapperImpl;
import com.project.system.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;
    @Spy
    UserMapperImpl userMapper;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser(){
        User user =  new User();
        user.setUsername("catalina");
        user.setPassword("oranges");
        user.setRole(UserRole.STUDENT);
        UserDTO userDto = userMapper.toDTO(user);
        UserDTO newUser = userService.save(userDto);
        userMapper.toEntityUpdate(user, newUser);
        verify(userRepository, times(1)).save(user);

    }

    @Test
    public void testGetAllUser()
    {
        List<UserDTO> list = new ArrayList<>();
        UserDTO firstUser = new UserDTO(1L, "John", "John", "howtodoinjava", UserRole.STUDENT);
        UserDTO secondUser = new UserDTO(2L, "Alex", "kolenchiski", "alexk", UserRole.STUDENT);
        UserDTO thirdUser = new UserDTO(3L, "Steve", "Waugh", "swaugh", UserRole.STUDENT);
        list.add(firstUser);
        list.add(secondUser);
        list.add(thirdUser);
        list.forEach(e -> userMapper.toEntity(e));
        List<User> users = list
                .stream()
                .map(userMapper::toEntity)
                .collect(Collectors.toList());
        when(userRepository.findAll()).thenReturn(users);
        List<UserDTO> empList = userService.findAll();
        assertEquals(3, empList.size());
        verify(userRepository, times(1)).findAll();
    }


    @Test
    public void testGetEmployeeById()
    {
        when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "Lokesh", "GuptaJam", UserRole.STUDENT)));
        UserDTO user = userService.findById(1L);
        User newUser = userMapper.toEntity(user);
        assertEquals("Lokesh", newUser.getUsername());
        assertEquals("GuptaJam", newUser.getPassword());
        assertEquals(UserRole.STUDENT, newUser.getRole());
    }


}
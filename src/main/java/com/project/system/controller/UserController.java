package com.project.system.controller;

import com.project.system.dto.UserDto;
import com.project.system.entity.User;
import com.project.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid UserDto userDTO, BindingResult result) {

        if(result.hasErrors()) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        UserDto save = userService.save(userDTO);
        return ResponseEntity.ok(save);
    }
}

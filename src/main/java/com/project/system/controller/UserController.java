package com.project.system.controller;

import com.project.system.dto.UserDTO;
import com.project.system.service.UserService;
import com.project.system.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @DeleteMapping("delete/{id}")
    public void  delete(@PathVariable  Long id) {
         userService.deleteById(id);
    }

    @GetMapping("/list")
    public List<UserDTO> list() {
        return userService.findAll();
    }


    @GetMapping("/find/{id}")
    public UserDTO findById(@PathVariable final Long id){
        return userService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@Valid UserDTO userDTO, BindingResult result) {
        userValidator.validateUser(userDTO, result);
        if(result.hasErrors()) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        UserDTO save = userService.save(userDTO);

        return ResponseEntity.ok(save);
    }

}
